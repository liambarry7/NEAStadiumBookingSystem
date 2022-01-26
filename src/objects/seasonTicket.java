package objects;


public class seasonTicket {
    
    private int seasonTicketID;
    private int accountID;
    private String stand;
    private String seat;
    private int price;
    private String Age;
    private String expirationDate;

    public seasonTicket(int seasonTicketID, int accountID, String stand, String seat, int price, String Age, String expirationDate) {
        this.seasonTicketID = seasonTicketID;
        this.accountID = accountID;
        this.stand = stand;
        this.seat = seat;
        this.price = price;
        this.Age = Age;
        this.expirationDate = expirationDate;
    }
    
    public String toString() {
        return seasonTicketID + " " + accountID + " " +  stand + " " +  seat + " " +  price + " " +  Age + " " +  expirationDate;
    }

    public int getSeasonTicketID() {
        return seasonTicketID;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getStand() {
        return stand;
    }

    public String getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    public String getAge() {
        return Age;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
    
    
    
}
