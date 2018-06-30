/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.databaseEditor;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Unite;

/**
 *
 * @author Dinuka
 */
public interface UniteEditor extends Remote{

    /**
     *
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddUnite(Unite unite)throws RemoteException,IOException;

    /**
     *
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateUnite(Unite unite)throws RemoteException,IOException;

    /**
     *
     * @param unite_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteUnite(String unite_id)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public Unite searchUnite(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @param subject_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<Unite> getAllUnite(String subject_id)throws RemoteException,IOException;
}
