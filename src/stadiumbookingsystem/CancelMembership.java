/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stadiumbookingsystem;

import library.databaseSQL;

/**
 *
 * @author lb200992
 */
public class CancelMembership extends javax.swing.JFrame {

    /**
     * Creates new form CancelMembership
     */
    public CancelMembership() {
        initComponents();
        ConfirmMessage.setVisible(false);
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
        jLabel2 = new javax.swing.JLabel();
        ConfirmTickBox = new javax.swing.JCheckBox();
        BackButton = new javax.swing.JButton();
        CancelMembershipButton = new javax.swing.JButton();
        ConfirmMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Cancel Membership");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 20, 151, 34);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Are you sure you want to cancel your membership?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 50, 278, 68);

        ConfirmTickBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ConfirmTickBox.setText("Yes, I want to cancel my membership.");
        getContentPane().add(ConfirmTickBox);
        ConfirmTickBox.setBounds(50, 120, 233, 23);

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton);
        BackButton.setBounds(30, 190, 70, 23);

        CancelMembershipButton.setText("Cancel Membership");
        CancelMembershipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelMembershipButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CancelMembershipButton);
        CancelMembershipButton.setBounds(155, 190, 160, 23);

        ConfirmMessage.setForeground(new java.awt.Color(255, 0, 0));
        ConfirmMessage.setText("Please tick box to confirm cancellation");
        getContentPane().add(ConfirmMessage);
        ConfirmMessage.setBounds(40, 160, 250, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        Membership mp = new Membership();
        mp.setSize(370, 390);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CancelMembershipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelMembershipButtonActionPerformed
        Boolean selectedBox = ConfirmTickBox.isSelected();
        
        int accountID = databaseSQL.getCurrentUser().getAccountID();
        String status = "not a member";
        
        if (selectedBox == true) {
            ConfirmMessage.setVisible(false);
            //user can cancel membership as they have confirmed
            databaseSQL.updateMembershipStatus(accountID, status);
            
            //update current user to have updated details
            databaseSQL.resetCurrentUser(accountID);

            //return to membership menu
            Membership mp = new Membership();
            mp.setSize(370, 390);
            mp.setVisible(true);
            this.dispose();
        } else if (selectedBox == false) {
            ConfirmMessage.setVisible(true);
        }
    }//GEN-LAST:event_CancelMembershipButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CancelMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancelMembership().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CancelMembershipButton;
    private javax.swing.JLabel ConfirmMessage;
    private javax.swing.JCheckBox ConfirmTickBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
