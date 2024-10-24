package Examples.PaymentGateway2;

import Examples.PaymentGateway2.NotificationService.MerchantNotificationService;
import Examples.PaymentGateway2.NotificationService.NotificationService;
import Examples.PaymentGateway2.PaymentGateway.PaymentGateway;
import Examples.PaymentGateway2.RetryHandler.RetryHandler;
import Examples.PaymentGateway2.Transaction.PaymentMethod;
import Examples.PaymentGateway2.Transaction.Transaction;
import Examples.PaymentGateway2.User.Merchant;
import Examples.PaymentGateway2.User.User;
import Examples.PaymentGateway2.SecurityService.SecurityService;

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
