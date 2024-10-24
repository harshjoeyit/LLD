package Examples.PaymentGateway2.PaymentGateway;

import Examples.PaymentGateway2.Logger.Logger;
import Examples.PaymentGateway2.NotificationService.NotificationService;
import Examples.PaymentGateway2.PaymentProcessor.PaymentProcessor;
import Examples.PaymentGateway2.PaymentProcessor.PaymentProcessorFactory;
import Examples.PaymentGateway2.SecurityService.SecurityService;
import Examples.PaymentGateway2.Transaction.Transaction;
import Examples.PaymentGateway2.Transaction.TransactionStatus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// for timeout
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

public class PaymentGateway {
    NotificationService merchantNotifService;
    SecurityService securityService;

    // Create a thread pool with a fixed number of threads
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    // timeout for processTransaction completion
    private final int timeoutSeconds = 5;

    public PaymentGateway(
        NotificationService notificationService,
        SecurityService securityService
    ) {
        this.merchantNotifService = notificationService;
        this.securityService = securityService;
    }

    // 1. use thread pool
    // 2. use timeout
    public void processTransaction(Transaction transaction) {
        Future<?> future = executor.submit(() -> {
            Logger.getInstance().log("Processing payment for Txn: " + transaction.getTransactionId());
        
            // Validate the transaction and secure sensitive information
            if (!securityService.validateTransaction(transaction)) {
                Logger.getInstance().log("Invalid transaction: " + transaction.getTransactionId());
                return;
            }

            // Get the correct processor (e.g., Credit Card, UPI)
            PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(transaction.getPaymentMethod());
            processor.authorize(transaction);

            // Notify based on the transaction status
            merchantNotifService.sendNotification(transaction);
        });

        try {
            // Wait for the task to complete within the specified timeout
            future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch(TimeoutException e) {
            Logger.getInstance().log("Payment processing timed out for Txn: " + transaction.getTransactionId());
            // Mark as pending, can retry later if need
            transaction.setStatus(TransactionStatus.PENDING);
        } catch (Exception e) {
            Logger.getInstance().log("Error in payment processing: " + e.getMessage());
        }
    }

    public void refundPayment(Transaction transaction) {
        PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(transaction.getPaymentMethod());
        
        processor.refund(transaction);

        Logger.getInstance().log("Refund processed for Txn: " + transaction.getTransactionId());
    }
}
