package Examples.PaymentGateway2.PaymentProcessor;

import Examples.PaymentGateway2.Logger.Logger;
import Examples.PaymentGateway2.Transaction.Transaction;
import Examples.PaymentGateway2.Transaction.TransactionStatus;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void authorize(Transaction transaction) {
        // Logic to interact with the credit card processor API.
        // Example: call a remote API to process the payment
        // Update transaction status based on the response.
        Logger.getInstance().log("Authorizing Credit Card payment for Txn: " + transaction.getTransactionId());
        
        // Simulating an external API call
        transaction.setStatus(TransactionStatus.SUCCESS);
    }

    @Override
    public void refund(Transaction transaction) {
        // Logic to initiate refund via the credit card processor.
        Logger.getInstance().log("Refunding Credit Card payment for Txn: " + transaction.getTransactionId());
    }

    @Override
    public boolean retry(Transaction transaction) {
        // Retry logic, such as retrying failed payments
        Logger.getInstance().log("Retrying Credit Card payment for Txn: " + transaction.getTransactionId());
        return false; // If retry fails, return false
    }
}