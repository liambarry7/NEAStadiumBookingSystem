/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stadiumbookingsystem;

import java.util.ArrayList;
import library.databaseSQL;
import objects.payment;

/**
 *
 * @author lb200992
 */
public class BecomeMember extends javax.swing.JFrame {

    /**
     * Creates new form BecomeMember
     */
    public BecomeMember() {
        initComponents();
        setPaymentChoices();
        PaymentError.setVisible(false);
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
        PaymentSelecter = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PaymentError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Become Member");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 10, 170, 70);

        PaymentSelecter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        getContentPane().add(PaymentSelecter);
        PaymentSelecter.setBounds(30, 140, 230, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Becoming a member allows you to purchase tickets one week earier than general sale!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 70, 490, 20);

        BackButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(20, 320, 80, 23);

        jLabel3.setText("Select Payment method:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 120, 270, 14);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Price: ??100");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 240, 100, 14);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Purchase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 320, 100, 23);

        PaymentError.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        PaymentError.setForeground(new java.awt.Color(255, 0, 0));
        PaymentError.setText("Please add a payment method to purchase membership.");
        getContentPane().add(PaymentError);
        PaymentError.setBounds(30, 170, 340, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        Membership mp = new Membership();
        mp.setSize(370, 390);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (PaymentSelecter.getItemCount() == 0) {
            //diplay error message
            PaymentError.setVisible(true);
        } else {
            PaymentError.setVisible(false);
            //user can become a member
            int accountID = databaseSQL.getCurrentUser().getAccountID();
            String status = "member";
            databaseSQL.updateMembershipStatus(accountID, status);
            databaseSQL.resetCurrentUser(accountID);
            
            //return to membership menu
            Membership mp = new Membership();
            mp.setSize(370, 390);
            mp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void setPaymentChoices() {
        //creating an arraylist of all the user's card details
        int userID = databaseSQL.getCurrentUser().getAccountID();
        ArrayList<payment> paymentList = databaseSQL.getPaymentMethods(userID);

        //set array of user's card numbers the size of the ammount of cards they have
        String[] paymentOptions = new String[paymentList.size()];

        for (int i = 0; i < paymentList.size(); i++) {
            paymentOptions[i] = paymentList.get(i).getCardNumber();
        }
        
        System.out.println("\nUser payment methods: ");
        for (int i = 0; i < paymentOptions.length; i++) {
            System.out.println(paymentOptions[i]);
        }

        //set dropdown to array of card numbers
        PaymentSelecter.setModel(new javax.swing.DefaultComboBoxModel<>(paymentOptions));
    }
    
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
            java.util.logging.Logger.getLogger(BecomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BecomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BecomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BecomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BecomeMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel PaymentError;
    private javax.swing.JComboBox<String> PaymentSelecter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
