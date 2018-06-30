/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.controllers;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.QuestionAndAnswer;

/**
 *
 * @author Dinuka
 */
public interface QuestionAndAnswerController extends Remote{

    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddQuestionAndAnswer(QuestionAndAnswer questionAndAnswer)throws RemoteException,IOException;

    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateQuestionAndAnswer(QuestionAndAnswer questionAndAnswer)throws RemoteException,IOException;

    /**
     *
     * @param subject
     * @param unite
     * @param question_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteQuestionAndAnswer(String subject,String unite,String question_id)throws RemoteException,IOException;

    /**
     *
     * @param subject
     * @param unite
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public QuestionAndAnswer searchQuestionAndAnswer(String subject,String unite,String type,String key)throws RemoteException,IOException;

    /**
     *
     * @param subject
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<QuestionAndAnswer> getAllQuestionAndAnswers(String subject,String unite)throws RemoteException,IOException;
}
