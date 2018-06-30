/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template FILE, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.ResultEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Result;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write results details
 * @author Dinuka
 */
public class ResultEditorImpl implements ResultEditor {

    private File file;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     *
     * @param result
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddResult(Result result) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            file = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\results\\" + result.getExam_id() + result.getDate() + ".txt");
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = result.getStudent_id() + ":" + result.getResult() + ":";
            if (bufferedWriter.append(data) != null) {
                bufferedWriter.close();
                return true;
            } else {
                return false;
            }
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    /**
     *
     * @param exam_no
     * @param date
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Result> getAllResult(String exam_no, String date) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            file = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\results\\" + exam_no + date + ".txt");
            fileReader = new FileReader(file);
            ArrayList<Result> resultList = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 2 == 0) {
                        Result result = new Result(exam_no, date, split[i], Double.parseDouble(split[i + 1]));
                        resultList.add(result);
                    }
                }
            }
            return resultList;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    @Override
    public Result searchResult(String type, String key) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllResultFiles() throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            file = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\results");
            ArrayList<String> fileNames = new ArrayList<String>();
            File folder = file;
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    fileNames.add(listOfFiles[i].getName());
                    System.out.println("File " + listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            return fileNames;
        } finally {
            rwLock.readLock().unlock();
        }

    }

}
