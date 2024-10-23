package Examples.PaymentGateway.SecurityService;

import Examples.PaymentGateway.Transaction.Transaction;

public class SecurityService {
    private static SecurityService instance;

    private SecurityService() {
        // Initialize encryption algorithms, etc.
    }

    public static SecurityService getInstance() {
        if (instance == null) {
            instance = new SecurityService();
        }
        return instance;
    }

    public boolean validateTransaction(Transaction transaction) {
        // Add encryption, tokenization, etc. as needed.
        // This is a dummy implementation for now.
        return transaction.getAmount() > 0;
    }
}
