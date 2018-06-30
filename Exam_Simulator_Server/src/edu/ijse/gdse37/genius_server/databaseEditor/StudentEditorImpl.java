/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template FILE, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.StudentEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Student;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write Students details
 * @author Dinuka
 */
public class StudentEditorImpl implements StudentEditor {

    private final File FILE = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\Student.txt");
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * Method for add new Student
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddStudent(Student student) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            fileWriter = new FileWriter(FILE, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = student.getStudent_id() + ":" + student.getName() + ":" + student.getNic() + ":" + student.getEmail() + ":" + student.getTel() + ":" + student.getPassword() + ":";
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
     * Method for update student detail
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateStudent(Student student) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] studentList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    studentList = data.split(":");
                }
            }
            int updated = 0;
            for (int i = 0; i < studentList.length; i++) {
                if (studentList[i].equals(student.getStudent_id())) {
                    updated = i;
                    studentList[i] = student.getStudent_id();
                    studentList[i + 1] = student.getName();
                    studentList[i + 2] = student.getNic();
                    studentList[i + 3] = student.getEmail();
                    studentList[i + 4] = Integer.toString(student.getTel());
                    studentList[i + 5] = student.getPassword();
                    i += 5;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < studentList.length; i++) {
                fileWriter.write(studentList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            String[] newStudentList = data.split(":");
            if (studentList.length == newStudentList.length) {
                if (newStudentList[updated].equals(student.getStudent_id())) {
                    if (newStudentList[updated + 1].equals(student.getName())) {
                        if (newStudentList[updated + 2].equals(student.getNic())) {
                            if (newStudentList[updated + 3].equals(student.getEmail())) {
                                if (newStudentList[updated + 4].equals(Integer.toString(student.getTel()))) {
                                    if (newStudentList[updated + 5].equals(student.getPassword())) {
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
     * Method for delete student
     * @param student_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteStudent(String student_id) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] studentList = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    studentList = data.split(":");
                }
            }
            String[] newStudentList = new String[studentList.length - 5];
            for (int i = 0, j = 0; i < studentList.length; i++) {
                if (studentList[i].equals(student_id)) {
                    i += 5;
                } else {
                    newStudentList[j] = studentList[i];
                    j++;
                }
            }
            fileWriter = new FileWriter(FILE, false);
            for (int i = 0; i < newStudentList.length - 1; i++) {
                fileWriter.write(newStudentList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            newStudentList = data.split(":");
            if (studentList.length != newStudentList.length) {
                return true;
            } else {
                return false;
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * Method for search student
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public Student searchStudent(String type, String key) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            Student student = null;
            if (FILE.exists()) {
                fileReader = new FileReader(FILE);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    if ("student_id".equals(type)) {
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].equals(key)) {
                                student = new Student(split[i], split[i + 1], split[i + 2], split[i + 3], Integer.parseInt(split[i + 4]), split[i + 5]);
                            }
                        }
                    }
                    if ("name".equals(type)) {
                        for (int i = 0; i < split.length - 1; i++) {
                            if (split[i + 1].equals(key)) {
                                student = new Student(split[i], split[i + 1], split[i + 2], split[i + 3], Integer.parseInt(split[i + 4]), split[i + 5]);
                            }
                        }
                    }
                    ///other type
                }
            }
            return student;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     * Method for get all students
     * @return @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Student> getAllStudent() throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            fileReader = new FileReader(FILE);
            ArrayList<Student> studentList = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 6 == 0) {
                        Student student = new Student(split[i], split[i + 1], split[i + 2], split[i + 3], Integer.parseInt(split[i + 4]), split[i + 5]);
                        studentList.add(student);
                    }
                }
            }
            return studentList;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     * Method for check student password
     * @param student_id
     * @param password
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isPassword(String student_id, String password) throws RemoteException, IOException {
        if (FILE.exists()) {
            fileReader = new FileReader(FILE);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].equals(student_id) && split[i + 5].equals(password)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

}
