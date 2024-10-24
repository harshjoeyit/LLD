package Examples.PaymentGateway2.Transaction;

import Examples.PaymentGateway2.User.User;

import java.util.concurrent.atomic.AtomicReference;

public class Transaction {
    private String transactionId;
    private double amount;
    private String currency;
    private AtomicReference<TransactionStatus>  status;  // SUCCESS, PENDING, FAILED
    private PaymentMethod paymentMethod;  // CREDIT_CARD, UPI, etc.
    private User user;
    private int retryCount;

    // Constructor
    public Transaction(
        String transactionId, 
        double amount, 
        String currency, 
        PaymentMethod paymentMethod, 
        User user,
        int retryCount) {

        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        // Atomic field, since multiple thread might update the status
        this.status = new AtomicReference<>(TransactionStatus.PENDING); // default
        this.user = user;
        this.retryCount = retryCount;
    }

    // Getters adnn Setters
    
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TransactionStatus getStatus() {
        // atomic operations
        return this.status.get();
    }

    public void setStatus(TransactionStatus status) {
        // atomic operations
        this.status.set(status);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }
}
