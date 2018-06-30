/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.SubjectController;
import edu.ijse.gdse37.genius_server.databaseEditor.SubjectEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Subject;

/**
 *
 * @author Dinuka
 */
public class SubjectControllerImpl extends UnicastRemoteObject implements SubjectController{
    
    private SubjectEditorImpl subjectEditorImpl=new SubjectEditorImpl();
    
    /**
     *
     * @throws RemoteException
     */
    public SubjectControllerImpl() throws RemoteException{
    }

    /**
     *
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddSubject(Subject subject) throws RemoteException, IOException {
        return subjectEditorImpl.isAddSubject(subject);
    }

    /**
     *
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateSubject(Subject subject) throws RemoteException, IOException {
        return subjectEditorImpl.isUpdateSubject(subject);
    }

    /**
     *
     * @param subject_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteSubject(String subject_id) throws RemoteException, IOException {
        return subjectEditorImpl.isDeleteSubject(subject_id);
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
    public Subject searchSubject(String type,String key) throws RemoteException, IOException {
        return subjectEditorImpl.searchSubject(type,key);
    }

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Subject> getAllSubject() throws RemoteException, IOException {
        return subjectEditorImpl.getAllSubject();
    }
}
