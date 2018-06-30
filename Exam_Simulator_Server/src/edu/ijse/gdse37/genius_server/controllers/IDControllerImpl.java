/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.IDController;
import edu.ijse.gdse37.genius_server.databaseEditor.IDEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dinuka
 */
public class IDControllerImpl extends UnicastRemoteObject implements IDController{
    
    private final IDEditorImpl iDEditorImpl=new IDEditorImpl();
    
    IDControllerImpl()throws RemoteException{
        
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
        return iDEditorImpl.getLastId(type);
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
        return iDEditorImpl.getLastQuestionId(subject, unite);
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
        return iDEditorImpl.getLastUniteId(subject_id);
    }
}
