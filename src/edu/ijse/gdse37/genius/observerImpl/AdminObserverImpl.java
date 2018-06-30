/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius.observerImpl;

import edu.ijse.gdse37.genius.view.admin.Admin_Main_Window;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import edu.ijse.gdse37.genius_common.observer.AdminObserver;

/**
 *
 * @author Dinuka
 */
public class AdminObserverImpl extends UnicastRemoteObject implements AdminObserver{

    private final Admin_Main_Window admin_Main_Window;

    /**
     *
     * @param admin_Main_Window
     * @throws RemoteException
     */
    public AdminObserverImpl(Admin_Main_Window admin_Main_Window)throws RemoteException{
        this.admin_Main_Window=admin_Main_Window;
    }
    @Override
    public void update(String msg) throws RemoteException {
        admin_Main_Window.update(msg);
    }

    @Override
    public void showResults(String result) throws RemoteException {
         admin_Main_Window.showResults(result);
    }
}