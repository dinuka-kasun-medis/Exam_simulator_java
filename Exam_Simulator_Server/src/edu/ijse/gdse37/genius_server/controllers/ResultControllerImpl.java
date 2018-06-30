/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.ResultController;
import edu.ijse.gdse37.genius_server.databaseEditor.ResultEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Result;

/**
 *
 * @author Dinuka
 */
public class ResultControllerImpl extends UnicastRemoteObject implements ResultController {

    private ResultEditorImpl resultEditorImpl = new ResultEditorImpl();

    /**
     *
     * @throws RemoteException
     */
    public ResultControllerImpl() throws RemoteException {
    }

    /**
     *
     * @param result
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddResult(Result result) throws RemoteException, IOException {
        return resultEditorImpl.isAddResult(result);
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
    public Result searchResult(String type, String key) throws RemoteException, IOException {
        return resultEditorImpl.searchResult(type, key);
    }

    /**
     *
     * @param exam_no
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Result> getAllResult(String exam_no, String date) throws RemoteException, IOException {
        return resultEditorImpl.getAllResult(exam_no, date);
    }

    /**
     * 
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public ArrayList<String> getAllResultFiles() throws RemoteException, IOException {
        return resultEditorImpl.getAllResultFiles();
    }
}
