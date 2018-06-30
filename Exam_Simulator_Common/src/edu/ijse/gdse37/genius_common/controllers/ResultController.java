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
import edu.ijse.gdse37.genius_common.model.Result;

/**
 *
 * @author Dinuka
 */
public interface ResultController extends Remote{

    /**
     *
     * @param result
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddResult(Result result)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public Result searchResult(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @param exam_no
     * @param date
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<Result> getAllResult(String exam_no,String date)throws RemoteException,IOException;

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<String> getAllResultFiles()throws RemoteException,IOException;
}
