/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.view.other;

import edu.ijse.gdse37.genius.connector.ServerConnector;
import edu.ijse.gdse37.genius_common.controllers.QuestionAndAnswerController;
import edu.ijse.gdse37.genius_common.model.QuestionAndAnswer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinuka
 */
public class ChooseRandomQuestion {

    private static ArrayList<QuestionAndAnswer> questionAndAnswerList = new ArrayList<>();
    private static ArrayList<QuestionAndAnswer> randomQuestionAndAnswerList;
    private static ArrayList<Integer> questionNumbers;

    /*Method for choose random questions © Dinuka Kasun Medis*/
    public static ArrayList<QuestionAndAnswer> randomQuestions(String subject, String unite, int noOfQuestions) {
        try {
            QuestionAndAnswerController questionAndAnswerController = ServerConnector.getServerConnector().getquAndAnswerController();
            questionAndAnswerList = questionAndAnswerController.getAllQuestionAndAnswers(subject, unite);
            Random random = new Random();
            questionNumbers = new ArrayList<>();
            randomQuestionAndAnswerList = new ArrayList<>();
            for (int i = 0; i < noOfQuestions; i++) {
                int quzNo = random.nextInt(questionAndAnswerList.size());
                if (!questionNumbers.contains(quzNo)) {
                    questionNumbers.add(quzNo);
                } else {
                    noOfQuestions++;
                }
            }
            for (Integer questionNumber : questionNumbers) {
                randomQuestionAndAnswerList.add(questionAndAnswerList.get(questionNumber));
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return randomQuestionAndAnswerList;
    }

    public static int noOfAll(String subject, String unite) {
        int no=0;
        try {
            QuestionAndAnswerController questionAndAnswerController = ServerConnector.getServerConnector().getquAndAnswerController();
            questionAndAnswerList = questionAndAnswerController.getAllQuestionAndAnswers(subject, unite);
            no=questionAndAnswerList.size();
        } catch (NotBoundException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChooseRandomQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return no;
    }
}
