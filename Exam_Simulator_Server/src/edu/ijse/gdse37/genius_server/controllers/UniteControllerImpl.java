/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.UniteController;
import edu.ijse.gdse37.genius_server.databaseEditor.UniteEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Unite;

/**
 *
 * @author Dinuka
 */
public class UniteControllerImpl extends UnicastRemoteObject implements UniteController{
    
    private UniteEditorImpl uniteEditorImpl=new UniteEditorImpl();
    
    /**
     *
     * @throws RemoteException
     */
    public UniteControllerImpl()throws RemoteException{
    }

    /**
     *
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddUnite(Unite unite) throws RemoteException, IOException {
        return uniteEditorImpl.isAddUnite(unite);
    }

    /**
     *
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateUnite(Unite unite) throws RemoteException, IOException {
        return uniteEditorImpl.isUpdateUnite(unite);
    }

    /**
     *
     * @param unite_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteUnite(String unite_id) throws RemoteException, IOException {
        return uniteEditorImpl.isDeleteUnite(unite_id);
    }

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public Unite searchUnite(String type,String key) throws RemoteException, IOException {
        return uniteEditorImpl.searchUnite(type,key);
    }

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Unite> getAllUnite(String subject_id) throws RemoteException, IOException {
        return uniteEditorImpl.getAllUnite(subject_id);
    }
}
