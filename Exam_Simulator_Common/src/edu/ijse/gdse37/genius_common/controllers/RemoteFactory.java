/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dinuka
 */
public interface RemoteFactory extends Remote{

    /**
     *
     * @return
     * @throws RemoteException
     */
    public AdminController adminController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public QuestionAndAnswerController questionAndAnswerController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ResultController resultController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public StudentController studentController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public SubjectController subjectController() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public UniteController uniteController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ExamController examController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public IDController iDController()throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    public ExamAnswerSheetController examAnswerSheetController()throws RemoteException;
}
