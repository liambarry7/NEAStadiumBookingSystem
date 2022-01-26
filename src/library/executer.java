package library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class executer {
    
    public static ResultSet executeQuery(Connection con, String sql) {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //allow sql to be used on database
            ResultSet rs = stmt.executeQuery(sql); //takes sql line and executes statement and returns the result set (records)
            return rs;

        } catch (Exception e) {
            System.out.println("Error in getting result set when executing query: " + e);
        }
        return null;
    }

    public static void executeUpdateQuery(Connection con, String sql) {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //allowing sql to be used on database
            stmt.executeUpdate(sql); //executing the sql statement given to the method in the parameter
            
        } catch (Exception e) {
            System.out.println("Error in updating database when executing query: " + e);
        }
    }
    
}
