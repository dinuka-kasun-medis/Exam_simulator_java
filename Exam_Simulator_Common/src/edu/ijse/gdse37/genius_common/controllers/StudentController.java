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
import edu.ijse.gdse37.genius_common.model.Student;
import edu.ijse.gdse37.genius_common.observer.StudentObserver;

/**
 *
 * @author Dinuka
 */
public interface StudentController extends Remote{

    /**
     *
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddStudent(Student student)throws RemoteException,IOException;

    /**
     *
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isUpdateStudent(Student student)throws RemoteException,IOException;

    /**
     *
     * @param student_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isDeleteStudent(String student_id)throws RemoteException,IOException;

    /**
     *
     * @param student_id
     * @param password
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isPassword(String student_id,String password)throws RemoteException,IOException;

    /**
     *
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public Student searchStudent(String type,String key)throws RemoteException,IOException;

    /**
     *
     * @param studentObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isAddStudentObserver(StudentObserver studentObserver)throws RemoteException,IOException;

    /**
     *
     * @param studentObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean isRemoveStudentObserver(StudentObserver studentObserver)throws RemoteException,IOException;

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public ArrayList<Student> getAllStudent()throws RemoteException,IOException;

    /**
     *
     * @param result
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    public boolean sendResults(String result)throws RemoteException,IOException;
}
