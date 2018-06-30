/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.databaseEditor;

import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Dinuka
 */
public interface ExamAnswerSheetEditor extends Remote{

    /**
     *
     * @param exam_id
     * @param examAnswerSheetList
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddExamAnswerSheet(String exam_id,ArrayList<ExamAnswerSheet> examAnswerSheetList)throws RemoteException,IOException;

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteExamAnswerSheet(String exam_id)throws RemoteException,IOException;

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateExamAnswerSheet(String exam_id)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ExamAnswerSheet searchExamAnswerSheet(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<ExamAnswerSheet> getAllExamAnswerSheet(String exam_id)throws RemoteException,IOException;
}
