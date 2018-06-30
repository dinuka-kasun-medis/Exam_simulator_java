/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius_common.controllers.AdminController;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import edu.ijse.gdse37.genius_common.model.Admin;
import edu.ijse.gdse37.genius.observerImpl.AdminObserverImpl;
import edu.ijse.gdse37.genius.view.other.Encription;

/**
 *
 * @author Dinuka
 */
public class ViewAdminList extends javax.swing.JPanel {

    private static ManageAdminPanel manageAdminPanel;
    private AdminObserverImpl adminObserverImpl;
    private final Admin_Main_Window ADMIN_MAIN_WINDOW;

    /**
     * Creates new form ViewAdminList
     *
     * @param admin_Main_Window
     */
    public ViewAdminList(Admin_Main_Window admin_Main_Window) {
        initComponents();
        this.ADMIN_MAIN_WINDOW = admin_Main_Window;
        detailTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
        detailTable.getTableHeader().setBackground(Color.BLUE);
        refreshBtn.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWindowPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        mainWindowPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainWindowPanel.setLayout(null);

        detailTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        detailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin Id", "Name", "Email", "Tel", "NIC", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        detailTable.setRowHeight(30);
        jScrollPane1.setViewportView(detailTable);
        if (detailTable.getColumnModel().getColumnCount() > 0) {
            detailTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            detailTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            detailTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            detailTable.getColumnModel().getColumn(3).setPreferredWidth(75);
            detailTable.getColumnModel().getColumn(4).setPreferredWidth(75);
            detailTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        mainWindowPanel.add(jScrollPane1);
        jScrollPane1.setBounds(40, 70, 1060, 470);

        refreshBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        mainWindowPanel.add(refreshBtn);
        refreshBtn.setBounds(600, 570, 160, 40);

        cancelBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        mainWindowPanel.add(cancelBtn);
        cancelBtn.setBounds(780, 570, 170, 40);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        mainWindowPanel.add(jLabel8);
        jLabel8.setBounds(950, 540, 190, 90);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Details");
        mainWindowPanel.add(jLabel2);
        jLabel2.setBounds(460, 10, 220, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        try {
            AdminController adminController = ServerConnector.getServerConnector().getAdminController();
            DefaultTableModel dtm = (DefaultTableModel) detailTable.getModel();
            ArrayList<Admin> adminList = adminController.getAllAdmin();
            dtm.setRowCount(0);
            if (adminList != null) {
                for (Admin admin : adminList) {
                    Object[] data = {admin.getAdmin_id(), admin.getName(), admin.getEmail(),
                        admin.getTelephone(), admin.getNic(), Encription.decriptTxt(admin.getPassword())};
                    dtm.addRow(data);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error..");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        Admin_Main_Window.setBtnEnable();
        removeAdminObserver();
        manageAdminPanel = new ManageAdminPanel(ADMIN_MAIN_WINDOW);
        Admin_Main_Window.mainWindowPanel.removeAll();
        Admin_Main_Window.mainWindowPanel.add(manageAdminPanel);
        Admin_Main_Window.mainWindowPanel.repaint();
        Admin_Main_Window.mainWindowPanel.revalidate();
        manageAdminPanel.setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainWindowPanel;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables

    /*Method for remove admin Observer © Dinuka Kasun Medis*/
    private void removeAdminObserver() {
        try {
            AdminController adminController = ServerConnector.getServerConnector().getAdminController();
            adminObserverImpl = new AdminObserverImpl(ADMIN_MAIN_WINDOW);
            adminController.isRemoveAdminObserver(adminObserverImpl);
        } catch (NotBoundException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewAdminList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
