/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.ExamAnswerSheetController;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import edu.ijse.gdse37.genius_server.databaseEditor.ExamAnswerSheetEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Dinuka
 */
public class ExamAnswerSheetControllerImpl extends UnicastRemoteObject implements ExamAnswerSheetController{
   
    private final ExamAnswerSheetEditorImpl EXAM_ANSWER_SHEET_EDITOR_IMPL=new ExamAnswerSheetEditorImpl();
    
    /**
     *
     * @throws RemoteException
     */
    public ExamAnswerSheetControllerImpl()throws RemoteException{}
    
    /**
     * 
     * @param exam_id
     * @param examAnswerSheetList
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public boolean isAddExamAnswerSheet(String exam_id, ArrayList<ExamAnswerSheet> examAnswerSheetList) throws RemoteException, IOException {
        return EXAM_ANSWER_SHEET_EDITOR_IMPL.isAddExamAnswerSheet(exam_id, examAnswerSheetList);
    }

    /**
     * 
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public boolean isDeleteExamAnswerSheet(String exam_id) throws RemoteException, IOException {
        return EXAM_ANSWER_SHEET_EDITOR_IMPL.isDeleteExamAnswerSheet(exam_id);
    }

    /**
     * 
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public boolean isUpdateExamAnswerSheet(String exam_id) throws RemoteException, IOException {
        return EXAM_ANSWER_SHEET_EDITOR_IMPL.isUpdateExamAnswerSheet(exam_id);
    }

    /**
     * 
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public ExamAnswerSheet searchExamAnswerSheet(String type, String key) throws RemoteException, IOException {
        return EXAM_ANSWER_SHEET_EDITOR_IMPL.searchExamAnswerSheet(type, key);
    }

    /**
     * 
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public ArrayList<ExamAnswerSheet> getAllExamAnswerSheet(String exam_id) throws RemoteException, IOException {
        return EXAM_ANSWER_SHEET_EDITOR_IMPL.getAllExamAnswerSheet(exam_id);
    }
    
}
