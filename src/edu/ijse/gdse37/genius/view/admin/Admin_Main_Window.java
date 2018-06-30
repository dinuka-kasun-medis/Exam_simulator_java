/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinuka
 */
public class Admin_Main_Window extends javax.swing.JFrame {

    private ManageQuestionPanel manageQuestionPanel;
    private ExamPanel examPanel;
    private ManageAdminPanel manageAdminPanel;
    private ManageStudentPanel manageStudentPanel;
    private ReportPanel reportPanel;
    private ResultsPanel resultsPanel;
    private final AdminLogin ADMIN_LOGIN;
    private CompareStudentPanel compareStudentPanel;
    private final ResultsSavePanel resultsSavePanel = new ResultsSavePanel();
    private String window;

    /**
     *
     */
    public static String user_id;

    /**
     *
     */
    public static String exam_id;

    /**
     *
     */
    public static String subject;

    /**
     *
     */
    public static String unite;
    
    /**
     * 
     */
    public static int  noOfQuestions;

    /**
     * Creates new form Main_Window
     */
    public Admin_Main_Window() {
        setTitle("Genius Exam Simulator © Dinuka Kasun Medis <_dinuka.kasunds@gmail.com_>");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/edu/ijse/gdse37/genius/view/images/iconGenius.png")));
        this.ADMIN_LOGIN = new AdminLogin(this, rootPaneCheckingEnabled);
        initComponents();
        setLocationRelativeTo(null);
        setTime();
//        ADMIN_LOGIN.setVisible(true);
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
        mainBtnPanel = new javax.swing.JPanel();
        manageQuestionBtn = new javax.swing.JButton();
        manageAdminBtn = new javax.swing.JButton();
        examBtn = new javax.swing.JButton();
        compareStudentBtn = new javax.swing.JButton();
        manageStudentBtn = new javax.swing.JButton();
        resultsBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        mainWindowPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userNameLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(74, 195, 227));
        jPanel1.setLayout(null);

        mainBtnPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainBtnPanel.setLayout(null);

        manageQuestionBtn.setBackground(new java.awt.Color(162, 234, 249));
        manageQuestionBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        manageQuestionBtn.setText("Manage Question");
        manageQuestionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageQuestionBtnActionPerformed(evt);
            }
        });
        mainBtnPanel.add(manageQuestionBtn);
        manageQuestionBtn.setBounds(20, 20, 150, 40);

        manageAdminBtn.setBackground(new java.awt.Color(162, 234, 249));
        manageAdminBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        manageAdminBtn.setText("Manage Admin");
        manageAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminBtnActionPerformed(evt);
            }
        });
        mainBtnPanel.add(manageAdminBtn);
        manageAdminBtn.setBounds(20, 260, 150, 40);

        examBtn.setBackground(new java.awt.Color(162, 234, 249));
        examBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        examBtn.setText("Exam");
        examBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examBtnActionPerformed(evt);
            }
        });
        mainBtnPanel.add(examBtn);
        examBtn.setBounds(20, 80, 150, 40);

        compareStudentBtn.setBackground(new java.awt.Color(162, 234, 249));
        compareStudentBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        compareStudentBtn.setText("Compare Students");
        compareStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareStudentBtnActionPerformed(evt);
            }
        });
        mainBtnPanel.add(compareStudentBtn);
        compareStudentBtn.setBounds(20, 140, 150, 40);

        manageStudentBtn.setBackground(new java.awt.Color(162, 234, 249));
        manageStudentBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        manageStudentBtn.setText("Manage Students");
        manageStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentBtnActionPerformed(evt);
            }
        });
        mainBtnPanel.add(manageStudentBtn);
        manageStudentBtn.setBounds(20, 200, 150, 40);

        resultsBtn.setBackground(new java.awt.Color(162, 234, 249));
        resultsBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        resultsBtn.setText("Results");
        resultsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsBtnActionPerformed(evt);
            }
        });
        mainBtnPanel.add(resultsBtn);
        resultsBtn.setBounds(20, 320, 150, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        jLabel6.setToolTipText("");
        mainBtnPanel.add(jLabel6);
        jLabel6.setBounds(0, 530, 190, 110);

        jPanel1.add(mainBtnPanel);
        mainBtnPanel.setBounds(10, 80, 190, 640);

        mainWindowPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainWindowPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(233, 248, 248));
        jPanel3.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/LOGO.png"))); // NOI18N
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 1140, 640);

        mainWindowPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(mainWindowPanel);
        mainWindowPanel.setBounds(210, 80, 1140, 640);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 190, 70);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 190, 70);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/admin.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1170, 10, 60, 60);

        userNameLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        userNameLbl.setText("Admin");
        jPanel1.add(userNameLbl);
        userNameLbl.setBounds(1260, 10, 90, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Hi,");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1230, 10, 30, 20);

        timeLbl.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        timeLbl.setText("10:25:30");
        jPanel1.add(timeLbl);
        timeLbl.setBounds(1230, 30, 90, 30);

        dateLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dateLbl.setText("2016 November,10");
        jPanel1.add(dateLbl);
        dateLbl.setBounds(1230, 57, 140, 20);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GENIUS™ ©Dinuka_Kasun_Medis  dinuka.kasunds@gmail.com / 2016");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1000, 720, 350, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageQuestionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageQuestionBtnActionPerformed
        manageQuestionPanel = new ManageQuestionPanel(this);
        mainWindowPanel.removeAll();
        mainWindowPanel.add(manageQuestionPanel);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        manageQuestionPanel.setVisible(true);
    }//GEN-LAST:event_manageQuestionBtnActionPerformed

    private void manageAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminBtnActionPerformed
        window="admin";
        manageAdminPanel = new ManageAdminPanel(this);
        mainWindowPanel.removeAll();
        mainWindowPanel.add(manageAdminPanel);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        manageAdminPanel.setVisible(true);
    }//GEN-LAST:event_manageAdminBtnActionPerformed

    private void examBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examBtnActionPerformed
        window = "exam";
        examPanel = new ExamPanel(this);
        mainWindowPanel.removeAll();
        mainWindowPanel.add(examPanel);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        examPanel.setVisible(true);
    }//GEN-LAST:event_examBtnActionPerformed

    private void compareStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareStudentBtnActionPerformed
        compareStudentPanel = new CompareStudentPanel();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(compareStudentPanel);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        compareStudentPanel.setVisible(true);
    }//GEN-LAST:event_compareStudentBtnActionPerformed

    private void manageStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStudentBtnActionPerformed
        window="student";
        manageStudentPanel = new ManageStudentPanel(this);
        mainWindowPanel.removeAll();
        mainWindowPanel.add(manageStudentPanel);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        manageStudentPanel.setVisible(true);
    }//GEN-LAST:event_manageStudentBtnActionPerformed

    private void resultsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultsBtnActionPerformed
        resultsPanel = new ResultsPanel();
        mainWindowPanel.removeAll();
        mainWindowPanel.add(resultsPanel);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        resultsPanel.setVisible(true);
    }//GEN-LAST:event_resultsBtnActionPerformed

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
                if ("Synthetica".equals(info.getName())) {// Synthetica  Web Look and Feel
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin_Main_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton compareStudentBtn;
    private javax.swing.JLabel dateLbl;
    private static javax.swing.JButton examBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel mainBtnPanel;
    public static javax.swing.JPanel mainWindowPanel;
    private static javax.swing.JButton manageAdminBtn;
    private static javax.swing.JButton manageQuestionBtn;
    private static javax.swing.JButton manageStudentBtn;
    private static javax.swing.JButton resultsBtn;
    private javax.swing.JLabel timeLbl;
    public static javax.swing.JLabel userNameLbl;
    // End of variables declaration//GEN-END:variables

    /*Method for set time and date © Dinuka Kasun Medis*/
    private void setTime() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy MMMM,dd");
                        timeLbl.setText(simpleDateFormat.format(date));
                        dateLbl.setText(simpleDateFormat2.format(date));
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Admin_Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }

    /*Method for set buttons disable © Dinuka Kasun Medis*/
    public static void setBtnDissable() {
        manageAdminBtn.setEnabled(false);
        manageQuestionBtn.setEnabled(false);
        manageStudentBtn.setEnabled(false);
        compareStudentBtn.setEnabled(false);
        resultsBtn.setEnabled(false);
        examBtn.setEnabled(false);
    }

    /*Method for set buttons enable © Dinuka Kasun Medis*/
    public static void setBtnEnable() {
        manageAdminBtn.setEnabled(true);
        manageQuestionBtn.setEnabled(true);
        manageStudentBtn.setEnabled(true);
        compareStudentBtn.setEnabled(true);
        resultsBtn.setEnabled(true);
        examBtn.setEnabled(true);
    }

    /**
     *
     * @param msg
     */
    public void update(String msg) {
        if (window.equals("student")||window.equals("admin")) {
            JOptionPane.showMessageDialog(this, "**"+msg);
        }else{
            //do nothing..
        }
    }

    /**
     * Method for show results to combo © Dinuka Kasun Medis
     * @param result
     */
    public void showResults(String result) {
        if (window.equals("exam")) {
            mainWindowPanel.removeAll();
            mainWindowPanel.add(resultsSavePanel);
            ResultsSavePanel.addResults(result);
            mainWindowPanel.repaint();
            mainWindowPanel.revalidate();
            resultsSavePanel.setVisible(true);
        }else{
            //Do nothing..
        }
    }

}