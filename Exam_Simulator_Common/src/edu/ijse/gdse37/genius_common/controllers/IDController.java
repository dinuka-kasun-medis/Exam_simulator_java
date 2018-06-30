/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.controllers;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dinuka
 */
public interface IDController extends Remote{

    /**
     *
     * @param type
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public String getLastId(String type)throws RemoteException,IOException;

    /**
     *
     * @param subject
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public String getLastQuestionId(String subject, String unite) throws RemoteException, IOException;

    /**
     *
     * @param subject_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public String getLastUniteId(String subject_id)throws RemoteException,IOException;
}
