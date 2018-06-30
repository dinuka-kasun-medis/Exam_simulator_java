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
import edu.ijse.gdse37.genius_common.model.Admin;
import edu.ijse.gdse37.genius_common.observer.AdminObserver;

/**
 *
 * @author Dinuka
 */
public interface AdminController extends Remote{

    /**
     *
     * @param admin
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddAdmin(Admin admin)throws RemoteException,IOException;

    /**
     *
     * @param admin
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateAdmin(Admin admin)throws RemoteException,IOException;

    /**
     *
     * @param admin_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteAdmin(String admin_id)throws RemoteException,IOException;

    /**
     *
     * @param admin_id
     * @param password
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isPassword(String admin_id,String password)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public Admin searchAdmin(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @param adminObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddAdminObserver(AdminObserver adminObserver)throws RemoteException,IOException;

    /**
     *
     * @param adminObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isRemoveAdminObserver(AdminObserver adminObserver)throws RemoteException,IOException;

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<Admin> getAllAdmin()throws RemoteException,IOException;
    
    /**
     *
     * @param exam_id
     * @throws RemoteException
     * @throws IOException
     */
    public void publishExam(String exam_id)throws RemoteException,IOException;
}
