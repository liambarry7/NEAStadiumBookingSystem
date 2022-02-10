/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stadiumbookingsystem;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import library.databaseSQL;
import objects.account;

/**
 *
 * @author kimia
 */
public class EditAccount extends javax.swing.JFrame {

    /**
     * Creates new form EditAccount
     */
    public EditAccount() {
        initComponents();
        
        setDetailsAndButtons();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        EmailField = new javax.swing.JTextField();
        AddressOneField = new javax.swing.JTextField();
        AddressTwoField = new javax.swing.JTextField();
        CityField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        DeleteAccountButton = new javax.swing.JButton();
        FirstNameValidBox = new javax.swing.JButton();
        LastNameValidBox = new javax.swing.JButton();
        EmailValidBox = new javax.swing.JButton();
        PhoneNoValidBox = new javax.swing.JButton();
        AddressOneValidBox = new javax.swing.JButton();
        AddressTwoValidBox = new javax.swing.JButton();
        CityValidBox = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        PostCodeField = new javax.swing.JTextField();
        PostCodeValidBox = new javax.swing.JButton();
        PhoneNumberField = new javax.swing.JFormattedTextField();
        DeleteConfirmBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("YOUR ACCOUNT");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("First Name:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Last Name:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Phone Number:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Address Line One:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Address Line Two:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("City/Town:");

        FirstNameField.setText("jTextField1");

        LastNameField.setText("jTextField2");

        EmailField.setText("jTextField3");

        AddressOneField.setText("jTextField5");

        AddressTwoField.setText("jTextField6");

        CityField.setText("jTextField7");

        SaveButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DeleteAccountButton.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        DeleteAccountButton.setForeground(new java.awt.Color(255, 51, 51));
        DeleteAccountButton.setText("DELETE ACCOUNT");
        DeleteAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAccountButtonActionPerformed(evt);
            }
        });

        FirstNameValidBox.setText("jButton3");

        LastNameValidBox.setText("jButton2");

        EmailValidBox.setText("jButton2");

        PhoneNoValidBox.setText("jButton2");

        AddressOneValidBox.setText("jButton2");

        AddressTwoValidBox.setText("jButton2");

        CityValidBox.setText("jButton2");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Post Code:");

        PostCodeField.setText("jTextField1");

        PostCodeValidBox.setText("jButton2");

        try {
            PhoneNumberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##### ######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        DeleteConfirmBox.setForeground(new java.awt.Color(255, 0, 0));
        DeleteConfirmBox.setText("Tick to confirm account deletion.");
        DeleteConfirmBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteConfirmBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FirstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(LastNameField)
                                    .addComponent(EmailField)
                                    .addComponent(AddressOneField)
                                    .addComponent(AddressTwoField)
                                    .addComponent(CityField)
                                    .addComponent(PostCodeField)
                                    .addComponent(PhoneNumberField)))
                            .addComponent(DeleteAccountButton)
                            .addComponent(DeleteConfirmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastNameValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneNoValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressOneValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressTwoValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CityValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PostCodeValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FirstNameValidBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FirstNameValidBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastNameValidBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailValidBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhoneNoValidBox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressOneField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressOneValidBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressTwoField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddressTwoValidBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CityField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CityValidBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PostCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PostCodeValidBox))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(13, 13, 13)
                .addComponent(DeleteConfirmBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteAccountButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        AccountMenu am = new AccountMenu();
        am.setSize(616, 540);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    public void setDetailsAndButtons() {
        FirstNameField.setText(databaseSQL.getCurrentUser().getFirstName());
        LastNameField.setText(databaseSQL.getCurrentUser().getLastName());
        EmailField.setText(databaseSQL.getCurrentUser().getEmail());
        PhoneNumberField.setText(databaseSQL.getCurrentUser().getPhoneNo());
        AddressOneField.setText(databaseSQL.getCurrentUser().getAddressOne());
        AddressTwoField.setText(databaseSQL.getCurrentUser().getAddressTwo());
        CityField.setText(databaseSQL.getCurrentUser().getCity());
        PostCodeField.setText(databaseSQL.getCurrentUser().getPostCode());
                
        
        //setting boxes to show if account information is valid or invalid
        FirstNameValidBox.setEnabled(false); //makes it so the button cannot be clicked
        FirstNameValidBox.setBackground(Color.green); //sets the colour of the box to green to show input is valid
        FirstNameValidBox.setText("Valid"); //sets text to say 'valid'
        
        LastNameValidBox.setEnabled(false);
        LastNameValidBox.setBackground(Color.green);
        LastNameValidBox.setText("Valid");
        
        EmailValidBox.setEnabled(false);
        EmailValidBox.setBackground(Color.green);
        EmailValidBox.setText("Valid");
        
        PhoneNoValidBox.setEnabled(false);
        PhoneNoValidBox.setBackground(Color.green);
        PhoneNoValidBox.setText("Valid");
        
        AddressOneValidBox.setEnabled(false);
        AddressOneValidBox.setBackground(Color.green);
        AddressOneValidBox.setText("Valid");
        
        AddressTwoValidBox.setEnabled(false);
        AddressTwoValidBox.setBackground(Color.green);
        AddressTwoValidBox.setText("Valid");
        
        CityValidBox.setEnabled(false);
        CityValidBox.setBackground(Color.green);
        CityValidBox.setText("Valid");
        
        PostCodeValidBox.setEnabled(false);
        PostCodeValidBox.setBackground(Color.green);
        PostCodeValidBox.setText("Valid");
    }
    
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        //Match with sign up code for updating account.
        //pull all text from fields, validate it and put it into an object.
        
        try {
            //first name check:
            Boolean validFirstName = false;
            String userFN = FirstNameField.getText();
            if (userFN.isEmpty()) {
                FirstNameValidBox.setBackground(Color.red);
                FirstNameValidBox.setText("Invalid");
                validFirstName = false;
            } else {
                FirstNameValidBox.setBackground(Color.green);
                FirstNameValidBox.setText("Valid");
                validFirstName = true;
            }
            
            //last name check:
            Boolean validLastName = false;
            String userLN = LastNameField.getText();
            if (userLN.isEmpty()) {
                LastNameValidBox.setBackground(Color.red);
                LastNameValidBox.setText("Invalid");
                validLastName = false;
            } else {
                LastNameValidBox.setBackground(Color.green);
                LastNameValidBox.setText("Valid");
                validLastName = true;
            }            
            
            //email check:
            Boolean validEmail = false;
            String userEmail = EmailField.getText();
            //regular expression for checking email is valid by looking for characters such as '@' and checking the ending is realistic (e.g. '.com')
            Pattern repEmail = Pattern.compile("^[0-9a-zA-Z]+([0-9a-zA-Z]*[-._+])*[0-9a-zA-Z]+@[0-9a-zA-Z]+([-.][0-9a-zA-Z]+)*([0-9a-zA-Z]*[.])[a-zA-Z]{2,6}$");
            Matcher mEmail = repEmail.matcher(userEmail); //checks if user input is valid by comparing to regular expression limits
            
            if (mEmail.matches()) { //returns true if email is valid
                //ErrorEmail.setVisible(false);   
                EmailValidBox.setBackground(Color.green);
                EmailValidBox.setText("Valid");
                validEmail = true; //email is valid, so condition is true
            } else {
                //ErrorEmail.setVisible(true); //displays error message to user
                EmailValidBox.setBackground(Color.red);
                EmailValidBox.setText("Invalid");
                validEmail = false; //email is invalid, so condition is false
            }
            
            //Phone Number Check:
            Boolean validPhoneNo = false;
            String userPN = PhoneNumberField.getText();
            System.out.println(userPN.length());
            
            
            //Address One Check:
            Boolean validAddressOne = false;
            String userAO = AddressOneField.getText();
            if (userAO.isEmpty()) {
                AddressOneValidBox.setBackground(Color.red);
                AddressOneValidBox.setText("Invalid");
                validAddressOne = false;
            } else {
                AddressOneValidBox.setBackground(Color.green);
                AddressOneValidBox.setText("Valid");
                validAddressOne = true; 
            }
            
            //Address Two Check:
            String userAT = AddressTwoField.getText();
       
            //City/Town Check:
            Boolean validCity = false;
            String userCity = CityField.getText();
            if (userCity.isEmpty()) {
                CityValidBox.setBackground(Color.red);
                CityValidBox.setText("Invalid");
                validCity = false;
            } else {
                CityValidBox.setBackground(Color.green);
                CityValidBox.setText("Valid");
                validCity = true;
            }
                        
            //Post Code Check:
            Boolean validPC = false;
            String userPost = PostCodeField.getText();
            String userPostCode = userPost.toUpperCase();
            //regular expression to validate the post code so that it incudes 5-7 alphanurmeric characters seperated by a sace, e.g. (RH2 3BG)
            Pattern repPC = Pattern.compile("^[A-Z]{1,2}[0-9][A-Z0-9]? ?[0-9][A-Z]{2}$");            
            Matcher mPC = repPC.matcher(userPostCode);
            if (mPC.matches()) { //returns true if Post Code is valid
                PostCodeValidBox.setBackground(Color.green);
                PostCodeValidBox.setText("Valid");
                validPC = true; //Post Code is valid, so condition is true
            } else {
                PostCodeValidBox.setBackground(Color.red);
                PostCodeValidBox.setText("Invalid");
                validPC = false; //Post Code is invalid, so condition is false
            }
            
            //Link to regEx: https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom#Validation            
            
            if (validFirstName == true && validLastName == true && validEmail == true && validAddressOne == true && validCity == true && validPC == true) {
                //update table
                int ID = databaseSQL.getCurrentUser().getAccountID();
                account changedDetails = new account(ID, userFN, userLN, userEmail, databaseSQL.getCurrentUser().getPassword(), userPN, userAO, userAT, userCity, userPost, databaseSQL.getCurrentUser().getMembership(), databaseSQL.getCurrentUser().getStadiumCredit());

                databaseSQL.updateAccountDetails(ID, changedDetails);
                
                //updates current user details
                databaseSQL.setCurrentUser(changedDetails.getEmail(), changedDetails.getPassword());
                
                AccountMenu am = new AccountMenu();
                am.setSize(616, 540);
                am.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {
            System.out.println("Error when saving new account details: " + e);
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAccountButtonActionPerformed
        //remove all data from database concering the deleted account
        if (DeleteConfirmBox.isSelected()) {
            int accountID = databaseSQL.getCurrentUser().getAccountID();
            databaseSQL.deleteAccountPaymentMethods(accountID);
            databaseSQL.deleteAccount(accountID);
            databaseSQL.deleteTickets(accountID);
            databaseSQL.deleteST(accountID);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Account Deleted.");
            System.exit(0);
        }
        
    }//GEN-LAST:event_DeleteAccountButtonActionPerformed

    private void DeleteConfirmBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteConfirmBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteConfirmBoxActionPerformed

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
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressOneField;
    private javax.swing.JButton AddressOneValidBox;
    private javax.swing.JTextField AddressTwoField;
    private javax.swing.JButton AddressTwoValidBox;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField CityField;
    private javax.swing.JButton CityValidBox;
    private javax.swing.JButton DeleteAccountButton;
    private javax.swing.JCheckBox DeleteConfirmBox;
    private javax.swing.JTextField EmailField;
    private javax.swing.JButton EmailValidBox;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JButton FirstNameValidBox;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JButton LastNameValidBox;
    private javax.swing.JButton PhoneNoValidBox;
    private javax.swing.JFormattedTextField PhoneNumberField;
    private javax.swing.JTextField PostCodeField;
    private javax.swing.JButton PostCodeValidBox;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
