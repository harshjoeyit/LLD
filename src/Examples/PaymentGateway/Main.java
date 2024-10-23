package Examples.PaymentGateway;

import Examples.PaymentGateway.NotificationService.MerchantNotificationService;
import Examples.PaymentGateway.NotificationService.NotificationService;
import Examples.PaymentGateway.PaymentGateway.PaymentGateway;
import Examples.PaymentGateway.RetryHandler.RetryHandler;
import Examples.PaymentGateway.Transaction.PaymentMethod;
import Examples.PaymentGateway.Transaction.Transaction;
import Examples.PaymentGateway.User.Merchant;
import Examples.PaymentGateway.User.User;
import Examples.PaymentGateway.SecurityService.SecurityService;

public class Main {
    public static void main() {

        User user = new User("abc@gmail.com");
        Merchant merchant = new Merchant("merch@gmail.com", "M123");

        Transaction transaction = new Transaction("txn1", 125, "INR", PaymentMethod.UPI, user, 0);

        NotificationService merchantNotificationService = new MerchantNotificationService(merchant);

        SecurityService securityService = SecurityService.getInstance();

        PaymentGateway paymentGateway = new PaymentGateway(merchantNotificationService, securityService);

        // process transaction
        paymentGateway.processTransaction(transaction);

        // refund
        paymentGateway.refundPayment(transaction);

        RetryHandler retryHandler = new RetryHandler();

        // retry to get transaction status
        retryHandler.retryTransaction(transaction);
    }
}
