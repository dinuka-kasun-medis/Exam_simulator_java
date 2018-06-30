/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dinuka
 */
public interface AdminObserver extends Remote{

    /**
     *
     * @param msg
     * @throws RemoteException
     */
    public void update(String msg)throws RemoteException;

    /**
     *
     * @param result
     * @throws RemoteException
     */
    public void showResults(String result)throws RemoteException;
}
