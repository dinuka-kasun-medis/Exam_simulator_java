/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.ExamController;
import edu.ijse.gdse37.genius_server.databaseEditor.ExamEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Exam;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;

/**
 *
 * @author Dinuka
 */
public class ExamControllerImpl extends UnicastRemoteObject implements ExamController{
    
    private final ExamEditorImpl EXAMEDITORIMPL=new ExamEditorImpl();
    
    /**
     *
     * @throws RemoteException
     */
    public ExamControllerImpl()throws RemoteException{
        //
    }
    
    /**
     *
     * @param exam
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddExam(Exam exam,ArrayList<ExamAnswerSheet> examAnswerSheetList) throws RemoteException, IOException {
        return EXAMEDITORIMPL.isAddExam(exam,examAnswerSheetList);
    }

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteExam(String exam_id) throws RemoteException, IOException {
        return EXAMEDITORIMPL.isDeleteExam(exam_id);
    }

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateExam(String exam_id) throws RemoteException, IOException {
        return EXAMEDITORIMPL.isUpdateExam(exam_id);
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
    public Exam searchExam(String type,String key) throws RemoteException, IOException {
        return EXAMEDITORIMPL.searchExam(type,key);
    }

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Exam> getAllExam() throws RemoteException, IOException {
        return EXAMEDITORIMPL.getAllExam();
    }
    
}
