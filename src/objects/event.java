package objects;

import java.time.LocalDate;


public class event {
   
    private int eventID;
    private String eventName;
    private String eventTime;
    private String eventDate;
    private int eventCapacity;
    private String eventDiscription;
    private int remainingTickets;
    private String eventType;
    private int eventBand;

    public event(int eventID, String eventName, String eventTime, String eventDate, int eventCapacity, String eventDiscription, int remainingTickets, String eventType, int eventBand) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
        this.eventCapacity = eventCapacity;
        this.eventDiscription = eventDiscription;
        this.remainingTickets = remainingTickets;
        this.eventType = eventType;
        this.eventBand = eventBand;
    }
    
    
    public String toString() {
        return eventID + " " + eventName + " " + eventTime + " " + eventDate + " " + eventCapacity + " " + eventDiscription + " " + remainingTickets + " " + eventType + " " + eventBand;
    }

    public int getEventID() {
        return eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventDate() {
        return eventDate;
    }

    public int getEventCapacity() {
        return eventCapacity;
    }

    public String getEventDiscription() {
        return eventDiscription;
    }

    public int getRemainingTickets() {
        return remainingTickets;
    }

    public String getEventType() {
        return eventType;
    }

    public int getEventBand() {
        return eventBand;
    }
    
    

}
