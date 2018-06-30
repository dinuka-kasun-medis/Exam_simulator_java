/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.observerImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import edu.ijse.gdse37.genius_common.observer.StudentObserver;
import edu.ijse.gdse37.genius.view.student.Student_Main_Window;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import java.util.ArrayList;

/**
 *
 * @author Dinuka
 */
public class StudentObserverImpl extends UnicastRemoteObject implements StudentObserver{

    private final Student_Main_Window student_Main_Window;

    /**
     *
     * @param student_Main_Window
     * @throws RemoteException
     */
    public StudentObserverImpl(Student_Main_Window student_Main_Window)throws RemoteException{
        this.student_Main_Window=student_Main_Window;
    }
    @Override
    public void update(String exam_id,int noOfQuestions,String paper,ArrayList<ExamAnswerSheet> examAnswerSheet) throws RemoteException {
        student_Main_Window.update(exam_id,noOfQuestions,paper,examAnswerSheet);
    }
    
}
