/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius.view.other.Encription;
import edu.ijse.gdse37.genius_common.controllers.AdminController;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import edu.ijse.gdse37.genius_common.model.Admin;

/**
 *
 * @author Dinuka
 */
public class AdminLogin extends javax.swing.JDialog {

    /**
     * Creates new form AdminLogin
     *
     * @param parent
     * @param modal
     */
    public AdminLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userIdTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        userIdTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(userIdTxt);
        userIdTxt.setBounds(160, 100, 240, 30);

        passwordTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(passwordTxt);
        passwordTxt.setBounds(160, 160, 240, 30);

        loginBtn.setBackground(new java.awt.Color(255, 255, 255));
        loginBtn.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        loginBtn.setText("Log in >>");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loginBtn);
        loginBtn.setBounds(230, 210, 170, 30);

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel4.setText("Password :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 160, 120, 30);

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel5.setText("User Id  :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 100, 120, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 250, 190, 90);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Login");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 0, 200, 40);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(235, 235, 239));
        jLabel6.setText("GENIUS™ ©Dinuka_Kasun_Medis  dinuka.kasunds@gmail.com / 2016");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(120, 310, 360, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/admin_1.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 0, 100, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        try {
            AdminController adminController = ServerConnector.getServerConnector().getAdminController();
            String admin_id = userIdTxt.getText();
            char[] password = passwordTxt.getPassword();
            String s = new String(password);
            byte[] password2 = s.getBytes("UTF-8");
            String passwordData = new String(password2);
            boolean isPassword = adminController.isPassword(admin_id, Encription.encriptTxt(passwordData));
            if (isPassword) {
                Admin admin = adminController.searchAdmin("admin_id", admin_id);
                String name = admin.getName();
                String[] split = name.split(" ");
                Admin_Main_Window.userNameLbl.setText(split[0]);
                Admin_Main_Window.user_id = userIdTxt.getText();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Password is wrong..");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdminLogin dialog = new AdminLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField userIdTxt;
    // End of variables declaration//GEN-END:variables

}