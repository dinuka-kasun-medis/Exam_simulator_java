/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.controllers;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Subject;

/**
 *
 * @author Dinuka
 */
public interface SubjectController extends Remote{

    /**
     *
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddSubject(Subject subject)throws RemoteException,IOException;

    /**
     *
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateSubject(Subject subject)throws RemoteException,IOException;

    /**
     *
     * @param subject_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteSubject(String subject_id)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public Subject searchSubject(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<Subject> getAllSubject()throws RemoteException,IOException;
}
