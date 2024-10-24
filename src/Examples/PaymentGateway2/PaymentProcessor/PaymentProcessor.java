package Examples.PaymentGateway2.PaymentProcessor;

import Examples.PaymentGateway2.Transaction.Transaction;

public interface PaymentProcessor {
    void authorize(Transaction transaction);
    void refund(Transaction transaction);
    boolean retry(Transaction transaction);
}
