package Examples.PaymentGateway2.PaymentProcessor;

import Examples.PaymentGateway2.Logger.Logger;
import Examples.PaymentGateway2.Transaction.Transaction;
import Examples.PaymentGateway2.Transaction.TransactionStatus;

public class UPIProcessor implements PaymentProcessor {
    @Override
    public void authorize(Transaction transaction) {
        Logger.getInstance().log("Authorizing UPI payment for Txn: " + transaction.getTransactionId());
        transaction.setStatus(TransactionStatus.SUCCESS);  // Simulate successful authorization
    }

    @Override
    public void refund(Transaction transaction) {
        Logger.getInstance().log("Refunding UPI payment for Txn: " + transaction.getTransactionId());
    }

    @Override
    public boolean retry(Transaction transaction) {
        Logger.getInstance().log("Retrying UPI payment for Txn: " + transaction.getTransactionId());
        return true;  // Assume retry succeeds
    }
}