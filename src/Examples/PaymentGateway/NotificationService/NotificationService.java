package Examples.PaymentGateway.NotificationService;

import Examples.PaymentGateway.Transaction.Transaction;

// Observer pattern
public interface NotificationService {
    public void sendNotification(Transaction transaction);
}
