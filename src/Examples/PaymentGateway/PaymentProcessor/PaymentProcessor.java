package Examples.PaymentGateway.PaymentProcessor;

import Examples.PaymentGateway.Transaction.Transaction;

public interface PaymentProcessor {
    void authorize(Transaction transaction);
    void refund(Transaction transaction);
    boolean retry(Transaction transaction);
}
