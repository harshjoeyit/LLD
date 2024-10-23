package Examples.PaymentGateway.PaymentGateway;

import Examples.PaymentGateway.Logger.Logger;
import Examples.PaymentGateway.NotificationService.NotificationService;
import Examples.PaymentGateway.PaymentProcessor.PaymentProcessor;
import Examples.PaymentGateway.PaymentProcessor.PaymentProcessorFactory;
import Examples.PaymentGateway.SecurityService.SecurityService;
import Examples.PaymentGateway.Transaction.Transaction;

public class PaymentGateway {
    NotificationService merchantNotifService;
    SecurityService securityService;

    public PaymentGateway(
        NotificationService notificationService,
        SecurityService securityService
    ) {
        this.merchantNotifService = notificationService;
        this.securityService = securityService;
    }

    public void processTransaction(Transaction transaction) {
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
    }

    public void refundPayment(Transaction transaction) {
        PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(transaction.getPaymentMethod());
        
        processor.refund(transaction);

        Logger.getInstance().log("Refund processed for Txn: " + transaction.getTransactionId());
    }
}
