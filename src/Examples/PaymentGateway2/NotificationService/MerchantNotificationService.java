package Examples.PaymentGateway2.NotificationService;

import Examples.PaymentGateway2.Logger.Logger;
import Examples.PaymentGateway2.Transaction.Transaction;
import Examples.PaymentGateway2.Transaction.TransactionStatus;
import Examples.PaymentGateway2.User.Merchant;

public class MerchantNotificationService implements NotificationService {
    Merchant merchant;

    public MerchantNotificationService(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public void sendNotification(Transaction transaction) {
        if (transaction.getStatus() == TransactionStatus.SUCCESS) {
            String message = "Payment success of amount: " + transaction.getAmount() + " from: " + transaction.getUser().getEmail();
            this.sendEmailNotification(this.merchant.getEmail(), message);
        }
    }

    public void sendEmailNotification(String email, String message) {
        // send email here
        Logger.getInstance().log("Email sent to: " + email + " with message: " + message);
    }
}
