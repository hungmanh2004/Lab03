public class Payment {
    private String transactionId;
    private String cardOwner;
    private float transactionAmount;
    private String transactionMessage;
    private float balance;
    private String transactionDate;

    // Constructor
    public Payment(String cardOwner, float transactionAmount, float balance) {
        this.cardOwner = cardOwner;
        this.transactionAmount = transactionAmount;
        this.balance = balance;
    }

    // xu ly thanh toan
    public boolean processPayment() {
        if (balance >= transactionAmount) {
            balance -= transactionAmount;
            transactionId = generateTransactionId();
            transactionMessage = "Transaction successful";
            transactionDate = java.time.LocalDate.now().toString();
            return true;
        } else {
            transactionMessage = "Insufficient funds";
            return false;
        }
    }

    // tao giao dich ngau nhien
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    public void displayTransactionDetails() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Card Owner: " + cardOwner);
        System.out.println("Transaction Amount: " + transactionAmount);
        System.out.println("Transaction Message: " + transactionMessage);
        System.out.println("Remaining Balance: " + balance);
        System.out.println("Transaction Date: " + transactionDate);
    }
}
