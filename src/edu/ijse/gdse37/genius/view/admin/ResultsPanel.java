/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.admin;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius_common.controllers.ExamController;
import edu.ijse.gdse37.genius_common.controllers.ResultController;
import edu.ijse.gdse37.genius_common.controllers.StudentController;
import edu.ijse.gdse37.genius_common.model.Exam;
import edu.ijse.gdse37.genius_common.model.Result;
import edu.ijse.gdse37.genius_common.model.Student;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dinuka
 */
public class ResultsPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResultsPanel
     */
    public ResultsPanel() {
        initComponents();
        loadResults();
        loadSubjectAndUnite();
        resultTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 18));
        resultTable.getTableHeader().setBackground(Color.BLUE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        mainWindowPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        examCombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        excelBtn = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();
        subjectTxt = new javax.swing.JLabel();
        unitTxt = new javax.swing.JLabel();

        mainWindowPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainWindowPanel.setLayout(null);

        resultTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Results"
            }
        ));
        resultTable.setRowHeight(30);
        jScrollPane1.setViewportView(resultTable);
        if (resultTable.getColumnModel().getColumnCount() > 0) {
            resultTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            resultTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        mainWindowPanel.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 1100, 490);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        mainWindowPanel.add(jLabel1);
        jLabel1.setBounds(950, 550, 190, 90);

        examCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        examCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                examComboItemStateChanged(evt);
            }
        });
        mainWindowPanel.add(examCombo);
        examCombo.setBounds(90, 20, 260, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Exam  :");
        mainWindowPanel.add(jLabel3);
        jLabel3.setBounds(30, 20, 90, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Unite :");
        mainWindowPanel.add(jLabel4);
        jLabel4.setBounds(700, 20, 90, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Subject :");
        mainWindowPanel.add(jLabel5);
        jLabel5.setBounds(360, 20, 90, 30);

        excelBtn.setBackground(new java.awt.Color(162, 234, 249));
        excelBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        excelBtn.setText("Get Excel Copy");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });
        mainWindowPanel.add(excelBtn);
        excelBtn.setBounds(20, 580, 220, 40);

        printBtn.setBackground(new java.awt.Color(162, 234, 249));
        printBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        printBtn.setText("Print");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        mainWindowPanel.add(printBtn);
        printBtn.setBounds(260, 580, 210, 40);

        subjectTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        subjectTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainWindowPanel.add(subjectTxt);
        subjectTxt.setBounds(430, 20, 240, 30);

        unitTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        unitTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainWindowPanel.add(unitTxt);
        unitTxt.setBounds(760, 20, 240, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainWindowPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void examComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_examComboItemStateChanged
        if (examCombo.getSelectedItem()!=null) {
            updateTable();
        }else{
            JOptionPane.showMessageDialog(this, "No data..");
        }
    }//GEN-LAST:event_examComboItemStateChanged

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Xcel", "xsl");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                JOptionPane.showMessageDialog(this, chooser.getSelectedFile().getAbsolutePath().replace("\\", "\\\\"));
                File file=new File(chooser.getSelectedFile().getAbsolutePath().replace("\\", "\\\\")+".xls");
                exportTable(resultTable,file);
            } catch (IOException ex) {
                Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_excelBtnActionPerformed

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        String exam_id = "E0001";
        String exam_name = "Java OOP";
        HashMap<String, Object> h1 = new HashMap<>();
        h1.put("exam_id", exam_id);
        h1.put("exam_name", exam_name);
        try {
            InputStream is = getClass().getResourceAsStream("jreports\\results.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, h1, new JRTableModelDataSource(resultTable.getModel()));
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> examCombo;
    private javax.swing.JButton excelBtn;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainWindowPanel;
    private javax.swing.JButton printBtn;
    private javax.swing.JTable resultTable;
    private javax.swing.JLabel subjectTxt;
    private javax.swing.JLabel unitTxt;
    // End of variables declaration//GEN-END:variables

    /*Method for all exams to combo © Dinuka Kasun Medis*/
    private void loadResults(){
        try {
            ResultController resultController=ServerConnector.getServerConnector().getResultController();
            ArrayList<String> resultsFiles=resultController.getAllResultFiles();
            for (String resultsFile : resultsFiles) {
                examCombo.addItem(resultsFile);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    /*Method for Load subjects and Unites © Dinuka Kasun Medis*/
    private void loadSubjectAndUnite(){
        try {
            ExamController examController=ServerConnector.getServerConnector().getExamController();
            String exam_id=examCombo.getSelectedItem().toString().substring(0, 5);
            Exam exam=examController.searchExam("exam_id", exam_id);
            subjectTxt.setText(exam.getSubject());
            unitTxt.setText(exam.getUnite());
        } catch (NotBoundException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Method for refresh table © Dinuka Kasun Medis*/
    private void updateTable(){
        try {
            ResultController resultController=ServerConnector.getServerConnector().getResultController();
            StudentController studentController=ServerConnector.getServerConnector().getStudentController();
            DefaultTableModel dtm=(DefaultTableModel) resultTable.getModel();
            String exam_id=examCombo.getSelectedItem().toString().substring(0, 5);
            String date=examCombo.getSelectedItem().toString().substring(5,15);
            ArrayList<Result> results=resultController.getAllResult(exam_id, date);
            dtm.setRowCount(0);
            for (Result result : results) {
                Student student=studentController.searchStudent("student_id", result.getStudent_id());
//                String presentage=Double.toString(result.getResult()*0.01)+"%";
                Object[]raw ={result.getStudent_id(),student.getName(),result.getResult()+"%"};
                dtm.addRow(raw);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResultsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Method for export table data to Excel sheet © Dinuka Kasun Medis*/
    private void exportTable(JTable table, File file1) throws IOException {
        TableModel model = table.getModel();
        File file = file1;
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++) {
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                out.write(model.getValueAt(i, j).toString() + "\t");
            }
            out.write("\n");
        }
        out.close();
    }
}
