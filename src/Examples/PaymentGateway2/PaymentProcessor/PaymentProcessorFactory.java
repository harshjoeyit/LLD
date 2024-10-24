package Examples.PaymentGateway2.PaymentProcessor;

import Examples.PaymentGateway2.Transaction.PaymentMethod;

public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentProcessor(PaymentMethod paymentMethod) {

        switch(paymentMethod) {
            case CREDIT_CARD:
                return new CreditCardProcessor();
            case UPI:
                return new UPIProcessor();
        }

        // default
        return new CreditCardProcessor();
    }
}
