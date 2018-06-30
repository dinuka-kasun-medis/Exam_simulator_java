/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.observerble;

import edu.ijse.gdse37.genius_common.model.Exam;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.observer.StudentObserver;
import edu.ijse.gdse37.genius_server.databaseEditor.ExamAnswerSheetEditorImpl;
import edu.ijse.gdse37.genius_server.databaseEditor.ExamEditorImpl;
import java.io.IOException;

/**
 *
 * @author Dinuka
 */
public class StudentObserverble  extends UnicastRemoteObject{

    private static ArrayList<StudentObserver> StudentObserverList=new ArrayList<>();
    private ExamAnswerSheetEditorImpl examAnswerSheetEditorImpl=new ExamAnswerSheetEditorImpl();
    private ExamEditorImpl examEditorImpl=new ExamEditorImpl();

    /**
     *
     * @throws RemoteException
     */
    public StudentObserverble()throws RemoteException{
        //
    }

    /**
     *
     * @param StudentObserver
     * @return
     */
    public boolean addStudentObserver(StudentObserver StudentObserver){
        return StudentObserverList.add(StudentObserver);
    }
    
    /**
     *
     * @param StudentObserver
     * @return
     */
    public boolean removeStudentObserver(StudentObserver StudentObserver){
        return StudentObserverList.remove(StudentObserver);
    }
    
    /**
     *
     * @param exam_id
     * @throws RemoteException
     */
    public void notifyStudentObservers(String exam_id) throws RemoteException, IOException{
        for (StudentObserver StudentObserver : StudentObserverList) {
            ArrayList<ExamAnswerSheet> examAnswerSheets=examAnswerSheetEditorImpl.getAllExamAnswerSheet(exam_id);
            Exam exam=examEditorImpl.searchExam("exam_id", exam_id);
            StudentObserver.update(exam_id,exam.getNo_of_questions(),exam.getContent(),examAnswerSheets);
        }
    }
}
