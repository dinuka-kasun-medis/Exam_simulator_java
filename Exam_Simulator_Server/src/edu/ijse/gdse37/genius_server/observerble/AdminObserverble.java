/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.observerble;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.observer.AdminObserver;

/**
 *
 * @author Dinuka
 */
public class AdminObserverble extends UnicastRemoteObject{

    private static ArrayList<AdminObserver> adminObserverList=new ArrayList<>();

    /**
     *
     * @throws RemoteException
     */
    public AdminObserverble()throws RemoteException{
        //
    }

    /**
     *
     * @param adminObserver
     * @return
     */
    public boolean addAdminObserver(AdminObserver adminObserver){
        return adminObserverList.add(adminObserver);
    }
    
    /**
     *
     * @param adminObserver
     * @return
     */
    public boolean removeAdminObserver(AdminObserver adminObserver){
        return adminObserverList.remove(adminObserver);
    }
    
    /**
     *
     * @param text
     * @throws RemoteException
     */
    public void notifyAdminObservers(String text) throws RemoteException{
        for (AdminObserver adminObserver : adminObserverList) {
            adminObserver.update(text);
            adminObserver.showResults(text);
        }
    }
}
