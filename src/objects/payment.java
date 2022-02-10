package objects;


public class payment {
    private int paymentID;
    private int accountID;
    private String cardHolderName;
    private String cardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String securityNumber; //hash itttttt

    public payment(int paymentID, int accountID, String cardHolderName, String cardNumber, String expirationMonth, String expirationYear, String securityNumber) {
        this.paymentID = paymentID;
        this.accountID = accountID;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.securityNumber = securityNumber;
    }
    
    public String toString() {
        return paymentID + " " + accountID + " " + cardHolderName + " " + cardNumber + " " + expirationMonth + " " + expirationYear + " " + securityNumber;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public String getSecurityNumber() {
        return securityNumber;
    }

    
    
}
