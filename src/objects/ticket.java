package objects;


public class ticket {
    private int ticketID;
    private int accountID;
    private int eventId;
    private String stand;
    private String seat;
    private int price;
    private String age;

    public ticket(int ticketID, int accountID, int eventId, String stand, String seat, int price, String age) {
        this.ticketID = ticketID;
        this.accountID = accountID;
        this.eventId = eventId;
        this.stand = stand;
        this.seat = seat;
        this.price = price;
        this.age = age;
    }
    
    public String toString() {
        return ticketID + " " + accountID + " " +  eventId + " " +  stand + " " +  seat + " " +  price + " " +  age;
    }
    
    public int getTicketID() {
        return ticketID;
    }

    public int getAccountID() {
        return accountID;
    }

    public int getEventId() {
        return eventId;
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
        return age;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAge(String age) {
        this.age = age;
    }    
    
}
