/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.AdminController;
import edu.ijse.gdse37.genius_common.databaseEditor.AdminEditor;
import edu.ijse.gdse37.genius_server.databaseEditor.AdminEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Admin;
import edu.ijse.gdse37.genius_common.observer.AdminObserver;
import edu.ijse.gdse37.genius_server.observerble.AdminObserverble;
import edu.ijse.gdse37.genius_server.observerble.StudentObserverble;

/**
 * Control all Administrative activities
 * @author Dinuka 
 */
public class AdminControllerImpl extends UnicastRemoteObject implements AdminController{
    
    private final AdminEditor ADMIN_EDITOR=new AdminEditorImpl();
    private final AdminObserverble ADMIN_OBSERVERBLE=new AdminObserverble();
    private final StudentObserverble STUDENT_OBSERVERBLE=new StudentObserverble();
    
    /**
     *
     * @throws RemoteException
     */
    public AdminControllerImpl()throws RemoteException{  
    }

    /**
     * Add new administrator into system
     * @param admin get administrator details.
     * @return if add was success this method will return true else if this will return false
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddAdmin(Admin admin) throws RemoteException, IOException {
        if (ADMIN_EDITOR.isAddAdmin(admin)) {
            ADMIN_OBSERVERBLE.notifyAdminObservers(admin.getAdmin_id()+" was added..\nPlease Refresh..");
            return true;
        }
        return false;
    }

    /**
     * Update Administrator details
     * @param admin get administrator details.
     * @return  if update was success this method will return true else if this will return false
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateAdmin(Admin admin) throws RemoteException, IOException {
        if(ADMIN_EDITOR.isUpdateAdmin(admin)){
            ADMIN_OBSERVERBLE.notifyAdminObservers(admin.getAdmin_id()+" was updated..\nPlease Refresh..");
            return true;
        }
        return false;
    }

    /**
     * Delete Administrator from System
     * @param admin_id identify the administrator by id
     * @return  if delete was success this method will return true else if this will return false
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteAdmin(String admin_id) throws RemoteException, IOException {
        if(ADMIN_EDITOR.isDeleteAdmin(admin_id)){
            ADMIN_OBSERVERBLE.notifyAdminObservers(admin_id+" was deleted..\nPlease Refresh..");
            return true;
        }
        return false;
    }

    /**
     * Search administrator in System
     * @param type name of identification key
     * @param key search id
     * @return if searched key exists this method will return Admin model.
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public Admin searchAdmin(String type,String key) throws RemoteException, IOException {
        return ADMIN_EDITOR.searchAdmin(type,key);
    }

    /**
     * get All Administrator details 
     * @return this will return all exists administrators details as an arrayList
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Admin> getAllAdmin() throws RemoteException, IOException {
        return ADMIN_EDITOR.getAllAdmin();
    }

    /**
     * if administrator view details in system, that administrator add as an Observer
     * @param adminObserver
     * @return true or false
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddAdminObserver(AdminObserver adminObserver) throws RemoteException, IOException {
        return ADMIN_OBSERVERBLE.addAdminObserver(adminObserver);
    }

    /**
     * this method remove added Administrator Observers
     * @param adminObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isRemoveAdminObserver(AdminObserver adminObserver) throws RemoteException, IOException {
        return ADMIN_OBSERVERBLE.removeAdminObserver(adminObserver);
    }

    /**
     * this method check password
     * @param admin_id administrator user id
     * @param password administrator password
     * @return if passwords are match correctly this method return true else false
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isPassword(String admin_id, String password) throws RemoteException, IOException {
        return ADMIN_EDITOR.isPassword(admin_id, password);
    }


    /**
     * @param exam_id exam id
     * this method check password
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public void publishExam(String exam_id) throws RemoteException, IOException {
        STUDENT_OBSERVERBLE.notifyStudentObservers(exam_id);
    }
    
    
}
