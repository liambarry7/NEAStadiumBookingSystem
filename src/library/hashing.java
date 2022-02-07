package library;

import java.security.MessageDigest;


public class hashing {
    
    public static String hasher(String password) {
        
        try {
            //Values returned by a hash function are called Message Digest
            //'SHA-256' - 256 bits Hash
            //Accepts a string variable specifying the name of the hashing alogrithm to be used and returns a hash value (message digest object implenting the algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //passes the data into the MessageDigest to be converted into byte array representing the string and passes it to the MessageDigest object
            md.update(password.getBytes());

            //calulates the hash function on the current object and reutrns the MessageDigest in the form of a byte array
            byte[] digest = md.digest();

            //Converts the byte array into hexadecimal 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            password = sb.toString();
            System.out.println("Hashed value: " + password);
        } catch (Exception e) {
            System.out.println("Error in hashing password: " + e);
        }
        
        return password;
    }
    
    
    
}

//https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
//https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm