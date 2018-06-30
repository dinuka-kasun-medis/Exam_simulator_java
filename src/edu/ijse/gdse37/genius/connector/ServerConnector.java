/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.connector;

import edu.ijse.gdse37.genius_common.controllers.AdminController;
import edu.ijse.gdse37.genius_common.controllers.ExamAnswerSheetController;
import edu.ijse.gdse37.genius_common.controllers.ExamController;
import edu.ijse.gdse37.genius_common.controllers.IDController;
import edu.ijse.gdse37.genius_common.controllers.QuestionAndAnswerController;
import edu.ijse.gdse37.genius_common.controllers.RemoteFactory;
import edu.ijse.gdse37.genius_common.controllers.ResultController;
import edu.ijse.gdse37.genius_common.controllers.StudentController;
import edu.ijse.gdse37.genius_common.controllers.SubjectController;
import edu.ijse.gdse37.genius_common.controllers.UniteController;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *j
 * @author Dinuka
 */
public class ServerConnector {
    private static ServerConnector serverConnector;
    private static RemoteFactory remoteFactory;

    /**
     *
     */
    public AdminController adminController;

    /**
     *
     */
    public QuestionAndAnswerController questionAndAnswerController;

    /**
     *
     */
    public ResultController resultController;

    /**
     *
     */
    public StudentController studentController;

    /**
     *
     */
    public SubjectController subjectController;

    /**
     *
     */
    public UniteController uniteController;

    /**
     *
     */
    public ExamController examController;

    /**
     *
     */
    public IDController iDController;

    /**
     *
     */
    public ExamAnswerSheetController examAnswerSheetController;
    
    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        remoteFactory=(RemoteFactory) Naming.lookup("rmi://localhost:5050/Server");
        adminController=remoteFactory.adminController();
        questionAndAnswerController=remoteFactory.questionAndAnswerController();
        resultController=remoteFactory.resultController();
        studentController=remoteFactory.studentController();
        subjectController=remoteFactory.subjectController();
        uniteController=remoteFactory.uniteController();
        examController=remoteFactory.examController();
        iDController=remoteFactory.iDController();
        examAnswerSheetController=remoteFactory.examAnswerSheetController();
    }
    
    /**
     *
     * @return
     * @throws NotBoundException
     * @throws MalformedURLException
     * @throws RemoteException
     */
    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        if (serverConnector==null) {
            serverConnector=new ServerConnector();
        }
        return serverConnector;
    }
    
    /**
     *
     * @return
     */
    public AdminController getAdminController(){
        return adminController;
    }
    
    /**
     *
     * @return
     */
    public QuestionAndAnswerController getquAndAnswerController(){
        return questionAndAnswerController;
    }
    
    /**
     *
     * @return
     */
    public ResultController getResultController(){
        return resultController;
    }
    
    /**
     *
     * @return
     */
    public StudentController getStudentController(){
        return studentController;
    }
    
    /**
     *
     * @return
     */
    public SubjectController getSubjectController(){
        return subjectController;
    }
     
    /**
     *
     * @return
     */
    public UniteController getUniteController(){
        return uniteController;
    }
    
    /**
     *
     * @return
     */
    public ExamController getExamController(){
        return examController;
    }
    
    /**
     *
     * @return
     */
    public IDController getIDController(){
        return iDController;
    }

    /**
     *
     * @return
     */
    public ExamAnswerSheetController getExamAnswerSheetController(){
        return examAnswerSheetController;
    }
}
