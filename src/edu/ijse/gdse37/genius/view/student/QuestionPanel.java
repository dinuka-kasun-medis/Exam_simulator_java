/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.student;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius_common.controllers.QuestionAndAnswerController;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import edu.ijse.gdse37.genius_common.model.QuestionAndAnswer;
import static edu.ijse.gdse37.genius.view.student.Student_Main_Window.mainWindowPanel;
import java.awt.Color;
import java.util.HashMap;

/**
 *
 * @author Dinuka
 */
public class QuestionPanel extends javax.swing.JPanel {

    private ArrayList<QuestionAndAnswer> questionAndAnswerList;
    private HashMap<Integer, String> historyList = new HashMap<>();
    private AnsweringQuestions answeringQuestions;
    private static int questionNo = 0;

    /**
     * Creates new form QuestionPanel
     *
     * @param subject
     * @param unite
     */
    public QuestionPanel(String subject, String unite) {
        try {
            initComponents();
            backBtn.setEnabled(false);
            QuestionAndAnswerController questionAndAnswerController = ServerConnector.getServerConnector().getquAndAnswerController();
            questionAndAnswerList = questionAndAnswerController.getAllQuestionAndAnswers(subject, unite);
            if (questionAndAnswerList != null) {
                nextBtn.doClick();
            } else {
                JOptionPane.showMessageDialog(this, "Somthing wrong...");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        backPageBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTxt = new javax.swing.JTextArea();
        answerCheckBox2 = new javax.swing.JCheckBox();
        answerCheckBox3 = new javax.swing.JCheckBox();
        answerCheckBox4 = new javax.swing.JCheckBox();
        answerCheckBox5 = new javax.swing.JCheckBox();
        answerCheckBox1 = new javax.swing.JCheckBox();
        backBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        questionNoLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        skipQno = new javax.swing.JSpinner();
        skipBtn = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        backPageBtn.setBackground(new java.awt.Color(255, 255, 255));
        backPageBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backPageBtn.setText("<< Back");
        backPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPageBtnActionPerformed(evt);
            }
        });
        jPanel2.add(backPageBtn);
        backPageBtn.setBounds(20, 20, 120, 30);

        questionTxt.setColumns(20);
        questionTxt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        questionTxt.setRows(5);
        jScrollPane1.setViewportView(questionTxt);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 1250, 210);

        answerCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        answerCheckBox2.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        answerCheckBox2.setText("answer 1");
        jPanel2.add(answerCheckBox2);
        answerCheckBox2.setBounds(90, 340, 650, 31);

        answerCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        answerCheckBox3.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        answerCheckBox3.setText("answer 2");
        jPanel2.add(answerCheckBox3);
        answerCheckBox3.setBounds(90, 380, 650, 31);

        answerCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        answerCheckBox4.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        answerCheckBox4.setText("answer 3");
        jPanel2.add(answerCheckBox4);
        answerCheckBox4.setBounds(90, 420, 650, 31);

        answerCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        answerCheckBox5.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        answerCheckBox5.setText("answer 5");
        jPanel2.add(answerCheckBox5);
        answerCheckBox5.setBounds(90, 500, 650, 31);

        answerCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        answerCheckBox1.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        answerCheckBox1.setText("answer 4");
        jPanel2.add(answerCheckBox1);
        answerCheckBox1.setBounds(90, 460, 660, 31);

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel2.add(backBtn);
        backBtn.setBounds(1090, 310, 90, 25);

        nextBtn.setBackground(new java.awt.Color(255, 255, 255));
        nextBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nextBtn.setText("Next >>");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });
        jPanel2.add(nextBtn);
        nextBtn.setBounds(1190, 310, 90, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("E.)");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(60, 500, 30, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Skip to Question :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(1020, 60, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("B.)");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(60, 380, 30, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("C.)");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(60, 420, 30, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("D.)");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(60, 460, 30, 30);

        confirmBtn.setBackground(new java.awt.Color(255, 255, 255));
        confirmBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        jPanel2.add(confirmBtn);
        confirmBtn.setBounds(80, 560, 260, 50);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/gdse37/genius/view/images/logo2New.png"))); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(1130, 550, 190, 90);

        questionNoLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        questionNoLbl.setForeground(new java.awt.Color(204, 204, 204));
        questionNoLbl.setText("Question 1 of 300");
        jPanel2.add(questionNoLbl);
        questionNoLbl.setBounds(30, 60, 230, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("A.)");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(60, 340, 30, 30);

        skipQno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        skipQno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                skipQnoStateChanged(evt);
            }
        });
        jPanel2.add(skipQno);
        skipQno.setBounds(1140, 60, 70, 30);

        skipBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        skipBtn.setText("Go");
        skipBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipBtnActionPerformed(evt);
            }
        });
        jPanel2.add(skipBtn);
        skipBtn.setBounds(1210, 60, 70, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPageBtnActionPerformed
        mainWindowPanel.removeAll();
        answeringQuestions = new AnsweringQuestions();
        mainWindowPanel.add(answeringQuestions);
        mainWindowPanel.repaint();
        mainWindowPanel.revalidate();
        answeringQuestions.setVisible(true);
    }//GEN-LAST:event_backPageBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        nextQuestion();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        boolean answer1 = answerCheckBox1.isSelected();
        boolean answer2 = answerCheckBox2.isSelected();
        boolean answer3 = answerCheckBox3.isSelected();
        boolean answer4 = answerCheckBox4.isSelected();
        boolean answer5 = answerCheckBox5.isSelected();
        System.out.println("questionNo =" + questionNo);
        checkAnswer(questionNo - 1, answer1, answer2, answer3, answer4, answer5);
        saveHistory(questionNo - 1, answer1, answer2, answer3, answer4, answer5);
        if (isHistoryEnable()) {
            backBtn.setEnabled(true);
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        reSetCheckBoxColour();
        if (historyList.size() == questionNo - 2) {
            if (questionNo - 2 < 0) {
                JOptionPane.showMessageDialog(this, "Sorry! no previous questions...");
            } else {
                showHistory(questionNo - 2);
                questionNo--;
            }
        }else{
            getQuestion(questionNo - 2);
            questionNo--;
        }
    }//GEN-LAST:event_backBtnActionPerformed

    private void skipQnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_skipQnoStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_skipQnoStateChanged

    private void skipBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipBtnActionPerformed
        getQuestion(Integer.parseInt(skipQno.getValue().toString()) - 1);
    }//GEN-LAST:event_skipBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox answerCheckBox1;
    private javax.swing.JCheckBox answerCheckBox2;
    private javax.swing.JCheckBox answerCheckBox3;
    private javax.swing.JCheckBox answerCheckBox4;
    private javax.swing.JCheckBox answerCheckBox5;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backPageBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel questionNoLbl;
    private javax.swing.JTextArea questionTxt;
    private javax.swing.JButton skipBtn;
    private javax.swing.JSpinner skipQno;
    // End of variables declaration//GEN-END:variables

    /*Method for show wrong answer © Dinuka Kasun Medis*/
    private void setWrongAnswer(boolean answer1, boolean answer2, boolean answer3, boolean answer4, boolean answer5) {
        if (answer1) {
            answerCheckBox1.setForeground(Color.red);
        }
        if (answer2) {
            answerCheckBox2.setForeground(Color.red);
        }
        if (answer3) {
            answerCheckBox3.setForeground(Color.red);
        }
        if (answer4) {
            answerCheckBox4.setForeground(Color.red);
        }
        if (answer5) {
            answerCheckBox5.setForeground(Color.red);
        }
    }

    /*Method for show correct answer © Dinuka Kasun Medis*/
    private void setCorrectAnswer(boolean isCorrect1, boolean isCorrect2, boolean isCorrect3, boolean isCorrect4, boolean isCorrect5) {
        Color colour = new java.awt.Color(0, 153, 0);
        if (isCorrect1) {
            answerCheckBox1.setForeground(colour);
        }
        if (isCorrect2) {
            answerCheckBox2.setForeground(colour);
        }
        if (isCorrect3) {
            answerCheckBox3.setForeground(colour);
        }
        if (isCorrect4) {
            answerCheckBox4.setForeground(colour);
        }
        if (isCorrect5) {
            answerCheckBox5.setForeground(colour);
        }
    }

    /*Method for save history © Dinuka Kasun Medis*/
    private void saveHistory(int qNo, boolean answer1, boolean answer2, boolean answer3, boolean answer4, boolean answer5) {
        String ans1 = Boolean.toString(answer1);
        String ans2 = Boolean.toString(answer2);
        String ans3 = Boolean.toString(answer3);
        String ans4 = Boolean.toString(answer4);
        String ans5 = Boolean.toString(answer5);
        String historyData = ans1 + ":" + ans2 + ":" + ans3 + ":" + ans4 + ":" + ans5;
        historyList.put(qNo, historyData);
    }

    /*Method for show previous answers and questions © Dinuka Kasun Medis*/
    private void showHistory(int qNo) {
        String data = historyList.get(qNo);
        System.out.println("historyList =" + historyList.size());
        System.out.println("data =" + data);
        System.out.println("questionNo =" + questionNo + "qNo =" + qNo);
        String[] split = data.split(":");
        getQuestion(qNo);
        boolean answer1 = Boolean.parseBoolean(split[0]);
        boolean answer2 = Boolean.parseBoolean(split[1]);
        boolean answer3 = Boolean.parseBoolean(split[2]);
        boolean answer4 = Boolean.parseBoolean(split[3]);
        boolean answer5 = Boolean.parseBoolean(split[4]);
        answerCheckBox1.setSelected(answer1);
        answerCheckBox2.setSelected(answer2);
        answerCheckBox3.setSelected(answer3);
        answerCheckBox4.setSelected(answer4);
        answerCheckBox5.setSelected(answer5);
        checkAnswer(qNo, answer1, answer2, answer3, answer4, answer5);
    }

    /*Method for show next questions © Dinuka Kasun Medis*/
    private void nextQuestion() {
        getQuestion(questionNo++);
        reSetCheckBoxColour();
    }

    /*Method for get questions © Dinuka Kasun Medis*/
    private void getQuestion(int qNo) {
        try {
            QuestionAndAnswer questionAndAnswer = questionAndAnswerList.get(qNo);
            skipQno.setValue(qNo + 1);
            questionNoLbl.setText("Question " + Integer.toString(qNo + 1) + " of " + Integer.toString(questionAndAnswerList.size()));
            questionTxt.setText(questionAndAnswer.getQuestion().replace("♥", "\n"));
            answerCheckBox1.setText(questionAndAnswer.getAnswer1());
            answerCheckBox2.setText(questionAndAnswer.getAnswer2());
            answerCheckBox3.setText(questionAndAnswer.getAnswer3());
            answerCheckBox4.setText(questionAndAnswer.getAnswer4());
            answerCheckBox5.setText(questionAndAnswer.getAnswer5());
            answerCheckBox1.setSelected(false);
            answerCheckBox2.setSelected(false);
            answerCheckBox3.setSelected(false);
            answerCheckBox4.setSelected(false);
            answerCheckBox5.setSelected(false);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Sorry! no more questions...");
        }
    }

    /*Method for check answers © Dinuka Kasun Medis*/
    private void checkAnswer(int no, boolean answer1, boolean answer2, boolean answer3, boolean answer4, boolean answer5) {
        QuestionAndAnswer aueAndAnswer = questionAndAnswerList.get(no);
        if (aueAndAnswer.isCorrect1() == answer1 && aueAndAnswer.isCorrect2() == answer2 && aueAndAnswer.isCorrect3() == answer3 && aueAndAnswer.isCorrect4() == answer4 && aueAndAnswer.isCorrect5() == answer5) {
            setCorrectAnswer(aueAndAnswer.isCorrect1(), aueAndAnswer.isCorrect2(), aueAndAnswer.isCorrect3(), aueAndAnswer.isCorrect4(), aueAndAnswer.isCorrect5());
        } else {
            setWrongAnswer(answer1, answer2, answer3, answer4, answer5);
            setCorrectAnswer(aueAndAnswer.isCorrect1(), aueAndAnswer.isCorrect2(), aueAndAnswer.isCorrect3(), aueAndAnswer.isCorrect4(), aueAndAnswer.isCorrect5());
        }
    }

    /*Method for reset checkBox forground colour © Dinuka Kasun Medis*/
    private void reSetCheckBoxColour() {
        answerCheckBox1.setForeground(Color.black);
        answerCheckBox2.setForeground(Color.black);
        answerCheckBox3.setForeground(Color.black);
        answerCheckBox4.setForeground(Color.black);
        answerCheckBox5.setForeground(Color.black);
    }
    
    /*Method for check is history exists © Dinuka Kasun Medis*/
    private boolean isHistoryEnable(){
        return historyList.size()>0;
    }

}
