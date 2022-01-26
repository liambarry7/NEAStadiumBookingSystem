/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stadiumbookingsystem;

import javax.swing.JOptionPane;
import library.databaseSQL;

/**
 *
 * @author kimia
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        ErrorMessage.setVisible(false);
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        EmailField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ErrorMessage = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        CreateAccountButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 270, 86, 35);

        EmailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(EmailField);
        EmailField.setBounds(270, 270, 252, 35);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 340, 75, 29);

        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton);
        LoginButton.setBounds(430, 400, 93, 36);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stadiumbookingsystem/BaseLogo.PNG"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 20, 431, 200);

        ErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        ErrorMessage.setText("Login details incorrect!");
        getContentPane().add(ErrorMessage);
        ErrorMessage.setBounds(270, 410, 160, 20);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(270, 340, 250, 40);

        CreateAccountButton.setText("Create Account");
        CreateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CreateAccountButton);
        CreateAccountButton.setBounds(130, 400, 130, 36);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        
        
        String email = EmailField.getText();
        String password = new String (jPasswordField1.getPassword());
        
        boolean valid = databaseSQL.userLogIn(email, password); //executes method to check user details against the database 
        
        if(valid == true) { //if database deatils are correct, it returns a true value to verify the login
            
            databaseSQL.setCurrentUser(email, password); //uses parameters to get record where email and password match
            System.out.println("Logging in....");
            MainMenu mm = new MainMenu(); //creates new main menu object to be opened
            mm.setVisible(true);
            this.dispose(); //closes login menu
            
        } else if (valid != true) {
            System.out.println("Login details incorrect!");
            ErrorMessage.setVisible(true); //displays login error message          
            
        }
        
        
        
        
        
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void CreateAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountButtonActionPerformed
        
        SignUp su = new SignUp(); //creates new object to create signup menu
        su.setSize(722, 700);
        su.setVisible(true);
        this.dispose(); //closes login window
    }//GEN-LAST:event_CreateAccountButtonActionPerformed

    private void EmailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAccountButton;
    private javax.swing.JTextField EmailField;
    private javax.swing.JLabel ErrorMessage;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
