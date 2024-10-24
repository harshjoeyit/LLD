package Examples.PaymentGateway2.RetryHandler;

import Examples.PaymentGateway2.Logger.Logger;
import Examples.PaymentGateway2.PaymentProcessor.PaymentProcessor;
import Examples.PaymentGateway2.PaymentProcessor.PaymentProcessorFactory;
import Examples.PaymentGateway2.Transaction.Transaction;
import Examples.PaymentGateway2.Transaction.TransactionStatus;

public class RetryHandler {
    public void retryTransaction(Transaction transaction) {
        int maxRetries = 3;
        int retryCount = transaction.getRetryCount();
        boolean success = false;
        PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(transaction.getPaymentMethod());

        while (retryCount < maxRetries) {
            retryCount++;
            transaction.setRetryCount(retryCount);
            
            Logger.getInstance().log("Retry attempt #" + (retryCount) + " for Txn: " + transaction.getTransactionId());
            
            // retry payment
            success = processor.retry(transaction);
            if (success) {
                Logger.getInstance().log("Retry succeeded for Txn: " + transaction.getTransactionId());
                return;
            }
  
            try {
                // Exponential backoff
                Thread.sleep((long) Math.pow(2, retryCount) * 1000);
            } catch (InterruptedException e) {
                Logger.getInstance().log("Retry interrupted for Txn: " + transaction.getTransactionId());
            }
        }

        if (!success) {
            Logger.getInstance().log("Retry attempts failed for Txn: " + transaction.getTransactionId());
            // udpate transaction
            transaction.setStatus(TransactionStatus.FAILURE);
        }
    }
}
