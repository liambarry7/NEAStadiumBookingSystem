
package objects;


public class account {
    
    private int accountID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNo;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String postCode;
    private String membership;
    private int stadiumCredit;

    public account(int accountID, String firstName, String lastName, String email, String password, String phoneNo, String addressOne, String addressTwo, String city, String postCode, String membership, int stadiumCredit) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.postCode = postCode;
        this.membership = membership;
        this.stadiumCredit = stadiumCredit;
    } 
    
    public String toString() {
        return accountID + " " + firstName + " " + lastName + " " + email + " " + password + " " + phoneNo + " " + addressOne + " " + addressTwo + " " + city + " " + postCode + " " + membership + " " + stadiumCredit;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getMembership() {
        return membership;
    }

    public int getStadiumCredit() {
        return stadiumCredit;
    }   

    
}
