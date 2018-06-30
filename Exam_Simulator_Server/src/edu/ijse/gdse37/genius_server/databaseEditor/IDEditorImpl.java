/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.IDEditor;
import edu.ijse.gdse37.genius_server.controllers.AdminControllerImpl;
import edu.ijse.gdse37.genius_server.controllers.ExamControllerImpl;
import edu.ijse.gdse37.genius_server.controllers.StudentControllerImpl;
import edu.ijse.gdse37.genius_server.controllers.SubjectControllerImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Admin;
import edu.ijse.gdse37.genius_common.model.Exam;
import edu.ijse.gdse37.genius_common.model.QuestionAndAnswer;
import edu.ijse.gdse37.genius_common.model.Student;
import edu.ijse.gdse37.genius_common.model.Subject;
import edu.ijse.gdse37.genius_common.model.Unite;
import edu.ijse.gdse37.genius_server.controllers.UniteControllerImpl;

/**
 * For generate new IDs
 *
 * @author Dinuka
 */
public class IDEditorImpl extends UnicastRemoteObject implements IDEditor {

    private ArrayList<Admin> adminList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Subject> subjectList = new ArrayList<>();
    private ArrayList<Unite> unitList = new ArrayList<>();
    private ArrayList<Exam> examList = new ArrayList<>();
    private ArrayList<QuestionAndAnswer> questionList = new ArrayList<>();

    /**
     *
     * @throws RemoteException
     */
    public IDEditorImpl() throws RemoteException {

    }

    /**
     *
     * @param type
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public String getLastId(String type) throws RemoteException, IOException {
        String newId = null;

        if (type.equals("Admin")) {
            adminList = new AdminControllerImpl().getAllAdmin();
            int sizeOfArray = adminList.size();
            String formattedNumber = String.format("%04d", sizeOfArray + 1);
            newId = "A" + formattedNumber;
        }

        if (type.equals("Student")) {
            studentList = new StudentControllerImpl().getAllStudent();
            int sizeOfArray = studentList.size();
            String formattedNumber = String.format("%04d", sizeOfArray + 1);
            newId = "S" + formattedNumber;
        }

        if (type.equals("Subject")) {
            subjectList = new SubjectControllerImpl().getAllSubject();
            int sizeOfArray = subjectList.size();
            String formattedNumber = String.format("%04d", sizeOfArray + 1);
            newId = "Sub" + formattedNumber;
        }

        if (type.equals("Exam")) {
            examList = new ExamControllerImpl().getAllExam();
            int sizeOfArray = examList.size();
            String formattedNumber = String.format("%04d", sizeOfArray + 1);
            newId = "E" + formattedNumber;
        }

        return newId;
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
    public String getLastQuestionId(String subject, String unite) throws RemoteException, IOException {
        String newQId = null;
        questionList = new QuestionAndAnswerEditorImpl().getAllQuestionAndAnswers(subject, unite);
        int sizeOfArray = questionList.size();
        System.out.println("examList size =" + examList.size());
        String formattedNumber = String.format("%04d", sizeOfArray + 1);
        newQId = "Q" + formattedNumber;
        return newQId;
    }

    /**
     * 
     * @param subject_id
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public String getLastUniteId(String subject_id) throws RemoteException, IOException {
        String newId = null;
        unitList = new UniteControllerImpl().getAllUnite(subject_id);
        int sizeOfArray = unitList.size();
        String formattedNumber = String.format("%04d", sizeOfArray + 1);
        newId = "U" + formattedNumber;
        return newId;
    }

}
