/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.ExamController;
import edu.ijse.gdse37.genius_common.controllers.AdminController;
import edu.ijse.gdse37.genius_common.controllers.ExamAnswerSheetController;
import edu.ijse.gdse37.genius_common.controllers.IDController;
import edu.ijse.gdse37.genius_common.controllers.RemoteFactory;
import edu.ijse.gdse37.genius_common.controllers.ResultController;
import edu.ijse.gdse37.genius_common.controllers.UniteController;
import edu.ijse.gdse37.genius_common.controllers.SubjectController;
import edu.ijse.gdse37.genius_common.controllers.StudentController;
import edu.ijse.gdse37.genius_common.controllers.QuestionAndAnswerController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dinuka
 */
public class RemoteFactoryImpl extends UnicastRemoteObject implements RemoteFactory{

    /**
     *
     * @throws RemoteException
     */
    public RemoteFactoryImpl()throws RemoteException{
        
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public AdminController adminController() throws RemoteException {
        return new AdminControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public QuestionAndAnswerController questionAndAnswerController() throws RemoteException {
        return new QuestionAndAnsweControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public ResultController resultController() throws RemoteException {
        return new ResultControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public StudentController studentController() throws RemoteException {
        return new StudentControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public SubjectController subjectController() throws RemoteException {
        return new SubjectControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public UniteController uniteController() throws RemoteException {
        return new UniteControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public ExamController examController() throws RemoteException {
        return new ExamControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public IDController iDController() throws RemoteException {
        return new IDControllerImpl();
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public ExamAnswerSheetController examAnswerSheetController() throws RemoteException {
        return new ExamAnswerSheetControllerImpl();
    }
   
}
