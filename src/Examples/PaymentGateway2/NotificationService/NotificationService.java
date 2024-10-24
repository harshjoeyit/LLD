package Examples.PaymentGateway2.NotificationService;

import Examples.PaymentGateway2.Transaction.Transaction;

// Observer pattern
public interface NotificationService {
    public void sendNotification(Transaction transaction);
}
