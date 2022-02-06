package stadiumbookingsystem;



public class StadiumBookingSystem {


    
    public static void main(String[] args) {
        
        
        //TO DO:
        // - add more comments
        // - remove unnecessary print lines and commented code
        
        //NOTES:
        //EMAIL CANNOT BE USED FOR MORE THAN ONE ACCOUNT
        //CARD NUMBER CANNOT BE USED FOR MORE THAN ONE ACCOUNT
        //make it so floor tickets can be bought
        //add sorts for different types of events 
        


        createLoginScreen();
        


    }
    

    
    
    
    
    public static void createLoginScreen(){
        Login l = new Login();
        //width, height
        l.setSize(687,500);
        l.setVisible(true); 
    }
        
    
}
