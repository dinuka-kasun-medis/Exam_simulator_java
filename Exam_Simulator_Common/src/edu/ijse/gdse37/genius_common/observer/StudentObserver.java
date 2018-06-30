/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.observer;

import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Dinuka
 */
public interface StudentObserver extends Remote{

    /**
     *
     * @param exam_id
     * @param noOfQuestions
     * @param paper
     * @param examAnswerSheet
     * @throws RemoteException
     */
    public void update(String exam_id,int noOfQuestions,String paper,ArrayList<ExamAnswerSheet> examAnswerSheet)throws RemoteException;
}
