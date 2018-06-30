/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.controllers;

import edu.ijse.gdse37.genius_common.controllers.StudentController;
import edu.ijse.gdse37.genius_server.databaseEditor.StudentEditorImpl;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Student;
import edu.ijse.gdse37.genius_common.observer.StudentObserver;
import edu.ijse.gdse37.genius_server.observerble.AdminObserverble;
import edu.ijse.gdse37.genius_server.observerble.StudentObserverble;

/**
 *
 * @author Dinuka
 */
public class StudentControllerImpl extends UnicastRemoteObject implements StudentController{
    
    private StudentEditorImpl studentEditorImpl=new StudentEditorImpl();
    private StudentObserverble studentObserverble=new StudentObserverble();
    private AdminObserverble adminObserverble=new AdminObserverble();
    
    /**
     *
     * @throws RemoteException
     */
    public StudentControllerImpl()throws RemoteException{
    }

    /**
     *
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddStudent(Student student) throws RemoteException, IOException {
        if(studentEditorImpl.isAddStudent(student)){
            adminObserverble.notifyAdminObservers(student.getStudent_id()+" was added..\nPlease Refresh..");
            return true;
        }
        return false;
    }

    /**
     *
     * @param student
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateStudent(Student student) throws RemoteException, IOException {
        if(studentEditorImpl.isUpdateStudent(student)){
            adminObserverble.notifyAdminObservers(student.getStudent_id()+" was updated..\nPlease Refresh..");
            return true;
        }
        return false;
    }

    /**
     *
     * @param student_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteStudent(String student_id) throws RemoteException, IOException {
        if(studentEditorImpl.isDeleteStudent(student_id)){
            adminObserverble.notifyAdminObservers(student_id+" was deleted..\nPlease Refresh..");
            return true;
        }
        return false;
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
    public Student searchStudent(String type,String key) throws RemoteException, IOException {
        return studentEditorImpl.searchStudent(type,key);
    }

    /**
     *
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<Student> getAllStudent() throws RemoteException, IOException {
        return studentEditorImpl.getAllStudent();
    }

    /**
     *
     * @param studentObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddStudentObserver(StudentObserver studentObserver) throws RemoteException, IOException {
        return studentObserverble.addStudentObserver(studentObserver);
    }

    /**
     *
     * @param studentObserver
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isRemoveStudentObserver(StudentObserver studentObserver) throws RemoteException, IOException {
        return studentObserverble.removeStudentObserver(studentObserver);
    }

    /**
     *
     * @param student_id
     * @param password
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isPassword(String student_id,String password) throws RemoteException, IOException {
        return studentEditorImpl.isPassword(student_id,password);
    }

    /**
     * 
     * @param result
     * @return
     * @throws RemoteException
     * @throws IOException 
     */
    @Override
    public boolean sendResults(String result) throws RemoteException, IOException {
        adminObserverble.notifyAdminObservers(result);
        return true;
    }
}
