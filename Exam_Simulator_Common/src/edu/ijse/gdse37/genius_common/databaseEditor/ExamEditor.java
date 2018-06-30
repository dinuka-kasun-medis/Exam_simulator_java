/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.databaseEditor;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Exam;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;

/**
 *
 * @author Dinuka
 */
public interface ExamEditor extends Remote{

    /**
     *
     * @param exam
     * @param examAnswerSheetList
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddExam(Exam exam,ArrayList<ExamAnswerSheet> examAnswerSheetList)throws RemoteException,IOException;

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteExam(String exam_id)throws RemoteException,IOException;

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateExam(String exam_id)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public Exam searchExam(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<Exam> getAllExam()throws RemoteException,IOException;
}
