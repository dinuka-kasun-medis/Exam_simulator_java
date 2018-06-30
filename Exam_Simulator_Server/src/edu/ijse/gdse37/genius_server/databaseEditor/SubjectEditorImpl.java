/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template FILE, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.SubjectEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Subject;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write Subjects details
 * @author Dinuka
 */
public class SubjectEditorImpl implements SubjectEditor {

    private final File FILE = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\Subject.txt");
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * Method for add new Subject
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddSubject(Subject subject) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            fileWriter = new FileWriter(FILE, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = subject.getSubject_id() + ":" + subject.getName() + ":";
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
     * Method for update subjects
     * @param subject
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateSubject(Subject subject) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] subjectList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    subjectList = data.split(":");
                }
            }
            int updated = 0;
            for (int i = 0; i < subjectList.length; i++) {
                if (subjectList[i].equals(subject.getSubject_id())) {
                    updated = i;
                    subjectList[i] = subject.getSubject_id();
                    subjectList[i + 1] = subject.getName();
                    i += 1;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < subjectList.length; i++) {
                fileWriter.write(subjectList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            String[] newSubjectList = data.split(":");
            if (subjectList.length == newSubjectList.length) {
                if (newSubjectList[updated].equals(subject.getSubject_id())) {
                    if (newSubjectList[updated + 1].equals(subject.getName())) {
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
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    /**
     * Method for delete subjects
     * @param subject_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteSubject(String subject_id) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] subjectList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    subjectList = data.split(":");
                }
            }
            String[] newSubjectList = new String[subjectList.length - 1];
            for (int i = 0, j = 0; i < subjectList.length; i++) {
                if (subjectList[i].equals(subject_id)) {
                    i += 1;
                } else {
                    newSubjectList[j] = subjectList[i];
                    j++;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < newSubjectList.length; i++) {
                fileWriter.write(newSubjectList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            newSubjectList = data.split(":");
            if (subjectList.length != newSubjectList.length) {
                return true;
            } else {
                return false;
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * Method for search subjects
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public Subject searchSubject(String type, String key) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            Subject subject = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    if ("subject_id".equals(type)) {
                        for (int i = 0; i < split.length-1; i++) {
                            if (split[i].equals(key)) {
                                subject = new Subject(split[i], split[i + 1]);
                            }
                        }
                    }
                    if ("subjectName".equals(type)) {
                        for (int i = 0; i < split.length-1; i++) {
                            if (split[i + 1].equals(key)) {
                                subject = new Subject(split[i], split[i + 1]);
                            }
                        }
                    }
                    ///other type
                }
            }
            return subject;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     * Method for get all subjects
     * @return @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Subject> getAllSubject() throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            fileReader = new FileReader(FILE);
            ArrayList<Subject> subjectList = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 2 == 0) {
                        Subject subject = new Subject(split[i], split[i + 1]);
                        subjectList.add(subject);
                    }
                }
            }
            return subjectList;
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
