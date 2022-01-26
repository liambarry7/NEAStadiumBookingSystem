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
        
//        databaseSQL.getAllAccounts();
        
        
        
//        databaseSQL.getAllPayments();
        
//        databaseSQL.removeAccount(7);
        

        
        
        
        
        
          
          
//        //Making the window fit the screen
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = (int)tk.getScreenSize().getWidth();
//        int ySize = (int)tk.getScreenSize().getHeight();
//        System.out.println(xSize + " " + ySize);



    }
    

    
    
    
    
    public static void createLoginScreen(){
        Login l = new Login();
        //width, height
        l.setSize(687,500);
        l.setVisible(true); 
    }
        
    
}
