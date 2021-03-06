/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius_common.controllers.IDController;
import edu.ijse.gdse37.genius_common.controllers.SubjectController;
import edu.ijse.gdse37.genius_common.controllers.UniteController;
import edu.ijse.gdse37.genius_common.model.Subject;
import edu.ijse.gdse37.genius_common.model.Unite;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinuka
 */
public class AddNewUniteForm extends javax.swing.JDialog {

    private static String subject;
    /**
     * Creates new form AddNewSubjectForm
     * @param parent
     * @param modal
     */
    public AddNewUniteForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/edu/ijse/gdse37/genius/view/images/iconGenius.png")));
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
        nameTxt = new javax.swing.JTextField();
        addUniteBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        unite_idTxt = new javax.swing.JTextField();
        subjectTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        nameTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(nameTxt);
        nameTxt.setBounds(170, 130, 240, 30);

        addUniteBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addUniteBtn.setText("Add");
        addUniteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUniteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addUniteBtn);
        addUniteBtn.setBounds(280, 180, 130, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Name :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 130, 120, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Unite Id :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 50, 120, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 160, 190, 90);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add New Unite");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 0, 220, 40);

        unite_idTxt.setEditable(false);
        unite_idTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(unite_idTxt);
        unite_idTxt.setBounds(170, 50, 240, 30);

        subjectTxt.setEditable(false);
        subjectTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel1.add(subjectTxt);
        subjectTxt.setBounds(170, 90, 240, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Subject  :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 90, 120, 30);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(235, 235, 239));
        jLabel7.setText("GENIUS™ ©Dinuka_Kasun_Medis  dinuka.kasunds@gmail.com / 2016");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(110, 220, 360, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUniteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUniteBtnActionPerformed
        try {
            UniteController uniteController=ServerConnector.getServerConnector().getUniteController();
            SubjectController subjectController=ServerConnector.getServerConnector().getSubjectController();
            String unite_id=unite_idTxt.getText();
            String subjectName=subjectTxt.getText();
            Subject subject=subjectController.searchSubject("subjectName", subjectName);
            String subject_id=subject.getSubject_id();
            String name=nameTxt.getText();
            Unite unite=new Unite(unite_id, subject_id, name);
            boolean isAdd=uniteController.isAddUnite(unite);
            if (isAdd) {
                JOptionPane.showMessageDialog(this, "Subject Added Sucsess..");
                this.dispose();
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(AddNewUniteForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AddNewUniteForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AddNewUniteForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddNewUniteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addUniteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewUniteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewUniteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewUniteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewUniteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AddNewUniteForm dialog = new AddNewUniteForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton addUniteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField nameTxt;
    private static javax.swing.JTextField subjectTxt;
    private static javax.swing.JTextField unite_idTxt;
    // End of variables declaration//GEN-END:variables

    /*Method for load new Id  © Dinuka Kasun Medis
     * @param subjectName
     */
    public static void loadNewId(String subjectName) {
        try {
            SubjectController subjectController=ServerConnector.getServerConnector().getSubjectController();
            subjectTxt.setText(subjectName);
            Subject subject=subjectController.searchSubject("subjectName", subjectName);
            String subject_id=subject.getSubject_id();
            IDController iDController = ServerConnector.getServerConnector().getIDController();
            String newId = iDController.getLastUniteId(subject_id);
            unite_idTxt.setText(newId);
        } catch (NotBoundException ex) {
            Logger.getLogger(AddNewSubjectForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AddNewSubjectForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(AddNewSubjectForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddNewSubjectForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
