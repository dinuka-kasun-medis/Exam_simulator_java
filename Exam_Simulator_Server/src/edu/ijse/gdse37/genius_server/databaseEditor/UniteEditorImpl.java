/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template FILE, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.UniteEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Unite;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write Unite details
 * @author Dinuka
 */
public class UniteEditorImpl implements UniteEditor {

    private final File FILE = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\Unite.txt");
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * Method for add new unites
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddUnite(Unite unite) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            fileWriter = new FileWriter(FILE, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = unite.getUnit_id() + ":" + unite.getSubject_id() + ":" + unite.getName() + ":";
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
     * Method for update unite details
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateUnite(Unite unite) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] uniteList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    uniteList = data.split(":");
                }
            }
            int updated = 0;
            for (int i = 0; i < uniteList.length; i++) {
                if (uniteList[i].equals(unite.getUnit_id())) {
                    updated = i;
                    uniteList[i] = unite.getUnit_id();
                    uniteList[i + 1] = unite.getSubject_id();
                    uniteList[i + 2] = unite.getName();
                    i += 2;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < uniteList.length; i++) {
                fileWriter.write(uniteList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            String[] newUniteList = data.split(":");
            if (uniteList.length == newUniteList.length) {
                if (newUniteList[updated].equals(unite.getUnit_id())) {
                    if (newUniteList[updated + 1].equals(unite.getSubject_id())) {
                        if (newUniteList[updated + 2].equals(unite.getName())) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * Method for delete unite
     * @param unite_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteUnite(String unite_id) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] uniteList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    uniteList = data.split(":");
                }
            }
            String[] newUniteList = new String[uniteList.length - 2];
            for (int i = 0, j = 0; i < uniteList.length; i++) {
                if (uniteList[i].equals(unite_id)) {
                    i += 2;
                } else {
                    newUniteList[j] = uniteList[i];
                    j++;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < newUniteList.length; i++) {
                fileWriter.write(newUniteList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            newUniteList = data.split(":");
            if (uniteList.length != newUniteList.length) {
                return true;
            } else {
                return false;
            }
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    /**
     * Method for search unite
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public Unite searchUnite(String type, String key) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            Unite unite = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    if ("unite_id".equals(type)) {
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].equals(key)) {
                                unite = new Unite(split[i], split[i + 1], split[i + 2]);
                            }
                        }
                    }
                    ///other type
                }
            }
            return unite;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     * Method for get all unites in selected subjects
     * @param subject_id
     * @return @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Unite> getAllUnite(String subject_id) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            fileReader = new FileReader(FILE);
            ArrayList<Unite> uniteList = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 3 == 0) {
                        Unite unite = new Unite(split[i], split[i + 1], split[i + 2]);
                        if (subject_id.equals(split[i + 1])) {
                            uniteList.add(unite);
                        }
                    }
                }
            }
            return uniteList;
        } finally {
            rwLock.readLock().unlock();
        }

    }

}
