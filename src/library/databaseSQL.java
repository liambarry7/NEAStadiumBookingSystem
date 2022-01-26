package library;

import objects.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class databaseSQL {
    
    //private static final String DatabaseLocation = System.getProperty("user.dir") + "\\Db.accdb";
    
    private static final String databaseLocation = System.getProperty("user.dir") + "\\SBSDatabase.accdb"; //location of database in files
    private static Connection con; //creating gloabal variable that can be used repeatedly rather than having to recreate new connection every time
    private static account currentUser; //global variable that stores the users details after they have logged in
    
    public static Connection getConnection() { //creating a connection to the database for when sql statements are executed
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://" + databaseLocation, "", ""); //sets variable con to the file location of the database file
            return con; 
        } catch (Exception e) {
            System.out.println("Error with getting connection to database: " + e);
        }
        return null; //return null value if no connection was made
    }
    
// <editor-fold defaultstate="collapsed" desc="Account">
    
    public static void addNewAccount(account na) {
        try {
            //creating sql statement of adding a record into the account table
            String sql = "INSERT INTO account VALUES ('"+na.getAccountID()+"','"+na.getFirstName()+"','"+na.getLastName()+"'"
                    + ",'"+na.getEmail()+"','"+na.getPassword()+"','"+na.getPhoneNo()+"','"+na.getAddressOne()+"','"+na.getAddressTwo()+"'"
                    + ",'"+na.getCity()+"','"+na.getPostCode()+"','"+na.getMembership()+"','"+na.getStadiumCredit()+"')";
            //Give statement the values from the account object that need to be put into the record
            executer.executeUpdateQuery(getConnection(), sql); //calling method from executer class to update the table using a connection and the sql statement as parameters        
            
            
            System.out.println("successfully added new account to database");
           
            con.close();
        } catch (Exception e) {
            System.out.println("Error in adding new account to databse: " + e);
        }
    }
    
    public static int getMaxAccountNumber() { //used for adding new accounts
        try {
            String sql = "SELECT MAX(accountid) AS accountNum FROM account"; //find highest number of accountID, save value as idNum from account table
            ResultSet rs = executer.executeQuery(getConnection(), sql); //uses connection to database and statement to fire query at the database
            rs.next();
            int idValue = rs.getInt("accountNum")+1; //adds one to highest ID value so that new account
            System.out.println("New account num: " + idValue); //next account value (id)
            
            rs.close();
            con.close();
            
            return idValue; //returns new ID number
            
        } catch (Exception e) {
            System.out.println("Error in finding maximum account number: " + e);
        }
        return -1;
    }
    
    public static void updateAccountDetails(int accountID, account cd) {
        try {
            String sql = "UPDATE account SET firstname = '"+cd.getFirstName()+"', lastname = '"+cd.getLastName()+"', email = '"+cd.getEmail()+"', "
                    + "phonenumber = '"+cd.getPhoneNo()+"',  addresslineone = '"+cd.getAddressOne()+"', addresslinetwo = '"+cd.getAddressTwo()+"',"
                    + "city = '"+cd.getCity()+"', postcode = '"+cd.getPostCode()+"'  WHERE accountid = '"+accountID+"'";
            
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Account details have been updated.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error with updating account details: " + e);
        }
    }
    
    public static void updateAccountStadiumCredit(int accountID, int credit) {
        try {
            String sql = "UPDATE account SET stadiumcredit = '"+credit+"' WHERE accountid = '"+accountID+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully updated user's stadium credit.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in updating user's stadium credit: " + e);
        }
    }
    
    public static void updateMembershipStatus(int accountID, String status) {
        try {
            String sql = "Update account Set membership = '"+status+"' WHERE accountid = '"+accountID+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully updates user's membership status.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in updating user's membership status: " + e);
        }
    }
    
    
    
    public static void deleteAccount(int accountID) { //used for when a user decides to terminate their account
        try {            
            String sql = "DELETE * FROM account WHERE accountid = '"+accountID+"' "; //statement used to find record with parametered account ID
            executer.executeUpdateQuery(getConnection(), sql); //uses connection to database and statement to fire update query at the database
            
            
            System.out.println("successfully deleted account.");            
            con.close();
        } catch (Exception e) {
            System.out.println("Error in deleting record in account table: " + e);
        }
    }    
    
    
    public static Boolean userLogIn(String loginEmail, String loginPassword) { //parameters taken from the text fields on login GUI
        try {
            String sql = "SELECT * FROM account WHERE email = '"+loginEmail+"'"; //selecting record where the email from the text fields match the database
            ResultSet rs = executer.executeQuery(getConnection(), sql); //uses connection to database and statement to fire query at the database
            
            //sets String to be empty so they can be rewrittern with the data from the result set
            String userEmail = ""; 
            String userPassword = "";
            
            while(rs.next()) { //result set returns results where the email details match and retrieves the password for that account
                userEmail = rs.getString("email");
                userPassword = rs.getString("password");                
            }
            
            //hash loginPassword to be used to compare against the hashed database password
            String hashLoginPassword = hashing.hasher(loginPassword);
            
            if (loginEmail.equals(userEmail) && hashLoginPassword.equals(userPassword)) { //if the login details and the record match, return true (meaning user can log in)
                rs.close();
                con.close();
                return true;
            } else {
                rs.close();
                con.close();
                return false;
            }
   
            
        } catch (Exception e) {
            System.out.println("Error getting login details from database: " + e);
        }
        return false;
    }   
    
    
    public static void setCurrentUser(String loginEmail, String loginPassword) {
        try {
            String sql = "SELECT * FROM account WHERE email = '" +loginEmail+ "'"; //selecting record where email matches database
            ResultSet rs = executer.executeQuery(getConnection(), sql); //uses connection to database and statement to fire query at the database
            
            //gets result set from sql statement
            while (rs.next()) {
                int id = rs.getInt("accountid"); //get record and store it in variable id
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phonenumber");
                String addressOne = rs.getString("addresslineone");
                String addressTwo = rs.getString("addresslinetwo");
                String city = rs.getString("city");
                String postCode = rs.getString("postcode");
                String membership = rs.getString("membership");
                int stadiumCredit = rs.getInt("stadiumCredit");
                
                //creates account object that is stored in a global variable for the logged in user so all their details can be accessed when logged in
                currentUser = new account (id, firstName, lastName, email, password, phoneNumber, addressOne, addressTwo, city, postCode, membership, stadiumCredit); 

                
            }
            
            rs.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error in setting current user: " + e);
        }       
        
    }
    
    public static void resetCurrentUser(int accountID) {
        try {
            String sql = "SELECT * FROM account WHERE accountid = '" +accountID+ "'"; //selecting record where email matches database
            ResultSet rs = executer.executeQuery(getConnection(), sql); //uses connection to database and statement to fire query at the database
            
            //gets result set from sql statement
            while (rs.next()) {
                int id = rs.getInt("accountid"); //get record and store it in variable id
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phonenumber");
                String addressOne = rs.getString("addresslineone");
                String addressTwo = rs.getString("addresslinetwo");
                String city = rs.getString("city");
                String postCode = rs.getString("postcode");
                String membership = rs.getString("membership");
                int stadiumCredit = rs.getInt("stadiumCredit");
                
                //creates account object that is stored in a global variable for the logged in user so all their details can be accessed when logged in
                currentUser = new account (id, firstName, lastName, email, password, phoneNumber, addressOne, addressTwo, city, postCode, membership, stadiumCredit); 

                
            }
            
            rs.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error in resetting current user: " + e);
        }       
    }
    
    public static account getCurrentUser() { //returns account object of logged in user so that object can be used in other classes
        return currentUser;
    }
    
   
//    public static void getAllAccounts() {
//        ArrayList<account> AccountList = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM account";
//            ResultSet rs = executer.executeQuery(getConnection(), sql);
//            while (rs.next()) {
//                int id = rs.getInt("accountid"); //get record and store it in variable id
//                String firstName = rs.getString("firstname");
//                String lastName = rs.getString("lastname");
//                String email = rs.getString("email");
//                String password = rs.getString("password");
//                String phoneNumber = rs.getString("phonenumber");
//                String addressOne = rs.getString("addresslineone");
//                String addressTwo = rs.getString("addresslinetwo");
//                String city = rs.getString("city");
//                String postCode = rs.getString("postcode");
//                String membership = rs.getString("membership");
//                int stadiumCredit = rs.getInt("stadiumCredit");
//                
//                
//                account ac = new account(id, firstName, lastName, email, password, phoneNumber, addressOne, addressTwo, city, postCode, membership, stadiumCredit); //creating new object to be added to the list
//                AccountList.add(ac); //adding new object to array list
//                
//                
//                //System.out.println(id + " " + firstName + " " + lastName + " " + email + " " + password + " " + phoneNumber + " " + addressOne + " " + addressTwo + " " + city + " " + postCode);
//            }
//            
//            //printing all accounts from account table in database
//            for (int i = 0; i < AccountList.size(); i++) {
//                    System.out.println(AccountList.get(i));                    
//                }
//            
//            
//            rs.close();
//            con.close();
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    
    
    // </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Payment">
    
    
    public static int getMaxPaymentNumber() {
        try {
            String sql = "SELECT MAX(paymentid) AS paymentNum FROM payment"; //find highest number of accountID, save value as idNum from account table
            ResultSet rs = executer.executeQuery(getConnection(), sql); //uses connection to database and statement to fire query at the database
            rs.next();
            int idValue = rs.getInt("paymentNum")+1; //adds one to highest ID value so that new account
            
            
            System.out.println("New payment num: " + idValue); //next account value (id)
            
            rs.close();
            con.close();
            
            return idValue; //returns new ID number
            
        } catch (Exception e) {
            System.out.println("Error in finding maximum payment number: " + e);
        }
        return -1;
    }
    
    
    public static void addNewPayment(payment newPaymentMethod) {
        try {
            //System.out.println("a");
            
            String sql = "INSERT INTO payment VALUES ('"+newPaymentMethod.getPaymentID()+"','"+newPaymentMethod.getAccountID()+
                    "','"+newPaymentMethod.getCardHolderName()+"','"+newPaymentMethod.getCardNumber()+"','"+newPaymentMethod.getExpirationMonth()+
                     "','"+newPaymentMethod.getExpirationYear()+"','"+newPaymentMethod.getSecurityNumber()+"')";
            
            //Give statement the values from the payment object that need to be put into the record
            executer.executeUpdateQuery(getConnection(), sql); //calling method from executer class to update the table using a connection and the sql statement as parameters
                        
            System.out.println("successfully added new payment to database");
           
            con.close();
        } catch (Exception e) {
            System.out.println("Error when adding new payment to database: " + e);
        }
        
    }
    
    public static void removePaymentMethod(int paymentID, String cardNumber){
        try {
            String sql = "DELETE FROM payment WHERE paymentid = '"+paymentID+"' AND cardnumber = '"+cardNumber+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Payment Method successfully removed.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in removing payment method: " + e);
        }
    }
    
    public static void deleteAccountPaymentMethods(int accountID) {
        try {
            String sql = "DELETE * FROM payment WHERE accountid = '"+accountID+"' ";
            executer.executeQuery(getConnection(), sql);
            
            System.out.println("Successfully deleted all payment methods for account");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in deleting payment method for account: " + e);
        }
    }
    
    public static ArrayList getPaymentMethods(int userID) { //used to return all of the users payment methods
        ArrayList<payment> userPaymentMethods = new ArrayList<>(); //creates arraylist which will store the payment objects
        try {
            String sql = "SELECT * FROM payment WHERE accountid = '"+userID+"'"; //uses paramter given in method call to find the correct records
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            
            while (rs.next()) {
                int paymentID = rs.getInt("paymentid"); //dont need to show user
                int accountID = rs.getInt("accountid"); //dont need to show user
                String cardName = rs.getString("cardholdername");
                String cardNumber = rs.getString("cardnumber");
                String expirationMonth = rs.getString("expirationmonth");
                String expirationYear = rs.getString("expirationyear");
                String securityNumber = rs.getString("securitynumber");
                
                payment pm = new payment(paymentID, accountID, cardName, cardNumber, expirationMonth, expirationYear, securityNumber);
                
                userPaymentMethods.add(pm); //adds new object to the arraylist of objects
            }
            con.close();
                  
        } catch (Exception e) {
            System.out.println("Error in getting payment details from database: " + e);
        }
        return userPaymentMethods;  
    }
    

    
    
//    public static void getAllPayments() {
//        ArrayList<Integer> numbers = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM payment";
//            ResultSet rs = executer.executeQuery(getConnection(), sql);
//            while (rs.next()) {
//                int id = rs.getInt("paymentid");
//                
//                numbers.add(id);
//            }
//            
//            for (int i = 0; i < numbers.size(); i++) {
//                System.out.println(numbers.get(i));
//                
//            }
//            
//            rs.close();
//            con.close();
//        } catch (Exception e) {
//            System.out.println("well this isnt working");
//        }
//    }
    
    
    // </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Events">
    
    public static ArrayList getEvents() {
        ArrayList<event> eventList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM event";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            
            while(rs.next()) {
                int eventID = rs.getInt("eventid");
                String eventName = rs.getString("eventname");
                String eventTime = rs.getString("eventtime");
                String eventDate = rs.getString("eventdate");
                int eventCap = rs.getInt("eventcapacity");
                String eventDesc = rs.getString("eventdescription");
                int remainingTickets = rs.getInt("remainingtickets");
                String eventType = rs.getString("eventtype");
                int eventBand = rs.getInt("eventBand");
                
                event ev = new event(eventID, eventName, eventTime, eventDate, eventCap, eventDesc, remainingTickets, eventType, eventBand);
                eventList.add(ev);
            }
            con.close();
            rs.close();
            
        } catch (Exception e) {
            System.out.println("Error in getting events: " + e);
        } 
        return eventList;
    }
    
    public static void updateRemainingSeats (int eventID, int remainingSeats) {
        try {
            String sql = "UPDATE event SET RemainingTickets = '"+remainingSeats+"' WHERE eventid = '"+eventID+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully updated remaining tickets value for event.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in updating event's remaining tickets: " + e);
        }
    }
    
    
// </editor-fold>
     
// <editor-fold defaultstate="collapsed" desc="Tickets">

    public static int getMaxTicketID() {
        try {
            String sql = "SELECT MAX(ticketid) AS ticketNum FROM tickets";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            rs.next();
            int idValue = rs.getInt("ticketNum")+1;
            
//            System.out.println("New ticket num: " + idValue);
            
            rs.close();
            con.close();
            
            return idValue;
        } catch (Exception e) {
            System.out.println("Error in finding maximum ticket number: " + e);
        }
        return -1;
    }
    
    public static void addTicket(ticket nt) {
        try {
            String sql = "INSERT INTO tickets(ticketid, accountid, eventid, stand, seat, price, age) VALUES ('"+nt.getTicketID()+"', '"+nt.getAccountID()+"', '"+nt.getEventId()+"'"
            + ",'"+nt.getStand()+"', '"+nt.getSeat()+"', '"+nt.getPrice()+"', '"+nt.getAge()+"') ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully added ticket to database.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error when adding new ticket to database: " + e);
        }
    }
    
    public static ArrayList getEventBookedTickets (int eventID, String standName) {
        ArrayList<ticket> bookedTickets = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tickets WHERE eventid = '"+eventID+"' AND stand = '"+standName+"' ";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            
            while(rs.next()) {
                int ticketID = rs.getInt("ticketid");
                int accountID = rs.getInt("accountid");
                int eventid = rs.getInt("eventid");
                String stand = rs.getString("stand");
                String seat = rs.getString("seat");
                int price = rs.getInt("price");
                String age = rs.getString("age");
                
                ticket bookedTicket = new ticket(ticketID, accountID, eventid, stand, seat, price, age);
                bookedTickets.add(bookedTicket);
            }
            
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error getting booked tickets from database: " + e);
        }
        return bookedTickets;
    }
    
    public static void deleteTickets(int accountID) { //for delete account
        try {
            String sql = "DELETE * FROM tickets WHERE accountid = '"+accountID+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully deleted tickets from database");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in deleting tickets from account in database. " + e);
        }
    }
    
    public static void refundTicket(int accountID, int ticketID) {
        try {
            String sql = "DELETE FROM tickets WHERE accountid = '"+accountID+"' AND ticketid = '"+ticketID+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully refunded ticket from account.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in refunded ticket from account: " + e);
        }
    }
    
    public static ArrayList getUserPurchasedTickets (int accountID) {
        ArrayList<ticket> ticketList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tickets WHERE accountid = '"+accountID+"' ";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            
            while (rs.next()) {
                int ticketID = rs.getInt("ticketid");
                int account = rs.getInt("accountid");
                int eventID = rs.getInt("eventid");
                String stand = rs.getString("stand");
                String seat = rs.getString("seat");
                int price = rs.getInt("price");
                String age = rs.getString("age");
                
                ticket purchasedTicket = new ticket(ticketID, account, eventID, stand, seat, price, age);
                ticketList.add(purchasedTicket);
            }
            
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in gettting user's booked tickets from database: " + e);
        }
        return ticketList;
    }
    
// </editor-fold>
      
// <editor-fold defaultstate="collapsed" desc="Season Ticket">

    public static int getMaxSTNumber() {
        try {
            String sql = "SELECT MAX(seasonticketid) AS stNum FROM seasontickets";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            rs.next();
            int idValue = rs.getInt("stNum")+1;
            System.out.println("New st num: " + idValue);
            
            rs.close();
            con.close();
            
            return idValue;
        } catch (Exception e) {
            System.out.println("Error in finding maximum season ticket ID number: " + e);
        }
        return -1;
    }
    
    public static void addSeasonTicket(seasonTicket st) {
        try {
            String sql = "INSERT INTO seasontickets(seasonticketid, accountid, stand, seat, price, age, expirationdate)"
                    + " VALUES '"+st.getSeasonTicketID()+"', '"+st.getAccountID()+"','"+st.getStand()+"','"+st.getSeat()+"',"
                    + "'"+st.getPrice()+"','"+st.getAge()+"','"+st.getExpirationDate()+"' ";
            
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully added seasonticket to database.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in adding season ticket to database: " + e);
        }
    }
    
    public static ArrayList getAllST() {
        ArrayList<seasonTicket> st = new ArrayList<>();
        try {
            String sql = "SELECT * FROM seasontickets";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            
            while(rs.next()) {
                int stID = rs.getInt("seasonticketid");
                int accountID = rs.getInt("accountid");
                String stand = rs.getString("stand");
                String seat = rs.getString("seat");
                int price = rs.getInt("price");
                String age = rs.getString("age");
                String exDate = rs.getString("expirationdate");
                
                seasonTicket seasonTicket = new seasonTicket(stID, accountID, stand, seat, price, age, exDate);
                st.add(seasonTicket);
            }
               
            
            System.out.println("Successfully got all season tickets from database.");
            con.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error in getting all season tickets: " + e);
        }
        return st;
    }
    
    public static ArrayList getUserST(int accountID) {
        ArrayList<seasonTicket> st = new ArrayList<>();
        try {
            String sql = "SELECT * FROM seasontickets WHERE accountid = '"+accountID+"' ";
            ResultSet rs = executer.executeQuery(getConnection(), sql);
            
            while(rs.next()) {
                int stID = rs.getInt("seasonticketid");
                int accID = rs.getInt("accountid");
                String stand = rs.getString("stand");
                String seat = rs.getString("seat");
                int price = rs.getInt("price");
                String age = rs.getString("age");
                String exDate = rs.getString("expirationdate");
                
                seasonTicket seasonTicket = new seasonTicket(stID, accID, stand, seat, price, age, exDate);
                st.add(seasonTicket);
            }
            
            System.out.println("Successfully got season ticket from database.");
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in getting season ticket from database: " + e);
        }
        return st;
    }
    
    public static void deleteST (int accountID) {
        try {
            String sql = "DELETE * FROM seasontickets WHERE accountid = '"+accountID+"' ";
            executer.executeUpdateQuery(getConnection(), sql);
            
            System.out.println("Successfully removed users season ticket from database.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error in deleting users season ticket: " + e);
        }
    }
    
// </editor-fold>    
}
