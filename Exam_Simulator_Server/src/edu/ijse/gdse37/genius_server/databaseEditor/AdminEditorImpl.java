/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template FILE, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.AdminEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Admin;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write administrator details
 * @author Dinuka
 */
public class AdminEditorImpl implements AdminEditor {

    private final File FILE = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\Administrator.txt");
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     *
     * @param admin
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddAdmin(Admin admin) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            fileWriter = new FileWriter(FILE, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = admin.getAdmin_id() + ":" + admin.getName() + ":" + admin.getEmail() + ":" + admin.getTelephone() + ":" + admin.getPassword() + ":" + admin.getNic() + ":";
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
     * @param admin
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateAdmin(Admin admin) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] adminList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    adminList = data.split(":");
                }
            }
            int updated = 0;
            for (int i = 0; i < adminList.length; i++) {
                if (adminList[i].equals(admin.getAdmin_id())) {
                    updated = i;
                    adminList[i] = admin.getAdmin_id();
                    adminList[i + 1] = admin.getName();
                    adminList[i + 2] = admin.getEmail();
                    adminList[i + 3] = Integer.toString(admin.getTelephone());
                    adminList[i + 4] = admin.getPassword();
                    adminList[i + 5] = admin.getNic();
                    i += 5;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < adminList.length; i++) {
                fileWriter.write(adminList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            String[] newAdminList = data.split(":");
            if (adminList.length == newAdminList.length) {
                if (newAdminList[updated].equals(admin.getAdmin_id())) {
                    if (newAdminList[updated + 1].equals(admin.getName())) {
                        if (newAdminList[updated + 2].equals(admin.getEmail())) {
                            if (newAdminList[updated + 3].equals(Integer.toString(admin.getTelephone()))) {
                                if (newAdminList[updated + 4].equals(admin.getPassword())) {
                                    if (newAdminList[updated + 5].equals(admin.getNic())) {
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
     *
     * @param admin_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteAdmin(String admin_id) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] adminList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    adminList = data.split(":");
                }
            }
            String[] newAdminList = new String[adminList.length - 5];
            for (int i = 0, j = 0; i < adminList.length; i++) {
                if (adminList[i].equals(admin_id)) {
                    i += 5;
                } else {
                    newAdminList[j] = adminList[i];
                    j++;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < newAdminList.length - 1; i++) {
                fileWriter.write(newAdminList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            newAdminList = data.split(":");
            if (adminList.length != newAdminList.length) {
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
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public Admin searchAdmin(String type, String key) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            Admin admin = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    if ("admin_id".equals(type)) {
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].equals(key)) {
                                admin = new Admin(split[i], split[i + 1], split[i + 2], Integer.parseInt(split[i + 3]), split[i + 4], split[i + 5]);
                            }
                        }
                    }
                    if ("name".equals(type)) {
                        for (int i = 0; i < split.length - 1; i++) {
                            if (split[i + 1].equals(key)) {
                                admin = new Admin(split[i], split[i + 1], split[i + 2], Integer.parseInt(split[i + 3]), split[i + 4], split[i + 5]);
                            }
                        }
                    }
                    ///other type
                }
            }
            return admin;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     *
     * @return @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Admin> getAllAdmin() throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            fileReader = new FileReader(FILE);
            ArrayList<Admin> adminList = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 6 == 0) {
                        Admin admin = new Admin(split[i], split[i + 1], split[i + 2], Integer.parseInt(split[i + 3]), split[i + 4], split[i + 5]);
                        adminList.add(admin);
                    }
                }
            }
            return adminList;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     *
     * @param admin_id
     * @param password
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isPassword(String admin_id, String password) throws RemoteException, IOException {
        if (FILE.exists()) {
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].equals(admin_id) && split[i + 4].equals(password)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

}
