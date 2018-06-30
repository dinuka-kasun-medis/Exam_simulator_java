/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.QuestionAndAnswerController;
import edu.ijse.gdse37.genius_server.databaseEditor.QuestionAndAnswerEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.QuestionAndAnswer;

/**
 *
 * @author Dinuka
 */
public class QuestionAndAnsweControllerImpl extends UnicastRemoteObject implements QuestionAndAnswerController{
    
    private QuestionAndAnswerEditorImpl questionAndAnswerEditorImpl=new QuestionAndAnswerEditorImpl();
    
    /**
     *
     * @throws RemoteException
     */
    public QuestionAndAnsweControllerImpl()throws RemoteException{   
    }

    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) throws RemoteException, IOException {
        return questionAndAnswerEditorImpl.isAddQuestionAndAnswer(questionAndAnswer);
    }

    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) throws RemoteException, IOException {
        return questionAndAnswerEditorImpl.isUpdateQuestionAndAnswer(questionAndAnswer);
    }

    /**
     *
     * @param subject
     * @param unite
     * @param question_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteQuestionAndAnswer(String subject,String unite,String question_id) throws RemoteException, IOException {
        return questionAndAnswerEditorImpl.isDeleteQuestionAndAnswer(subject,unite,question_id);
    }

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
    @Override
    public QuestionAndAnswer searchQuestionAndAnswer(String subject,String unite,String type,String key) throws RemoteException, IOException {
        return questionAndAnswerEditorImpl.searchQuestionAndAnswer(subject,unite,type,key);
    }

    /**
     *
     * @param subject
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<QuestionAndAnswer> getAllQuestionAndAnswers(String subject,String unite) throws RemoteException, IOException {
        return questionAndAnswerEditorImpl.getAllQuestionAndAnswers(subject,unite);
    }
}
