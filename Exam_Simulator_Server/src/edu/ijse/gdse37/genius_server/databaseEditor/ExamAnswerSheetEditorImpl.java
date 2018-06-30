/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.ExamAnswerSheetEditor;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write ExamAnswerSheet details
 * @author Dinuka
 */
public class ExamAnswerSheetEditorImpl implements ExamAnswerSheetEditor {

    private File file;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private ArrayList<ExamAnswerSheet> answerList;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    @Override
    public boolean isAddExamAnswerSheet(String exam_id, ArrayList<ExamAnswerSheet> examAnswerSheetList) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            file = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\exam\\" + exam_id + ".txt");
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            int i = 0;
            answerList = examAnswerSheetList;
            System.out.println("recived array size=" + answerList.size());
            for (ExamAnswerSheet examAnswerSheet1 : answerList) {
                data = examAnswerSheet1.isCorect1() + ":" + examAnswerSheet1.isCorect2() + ":" + examAnswerSheet1.isCorect3() + ":"
                        + examAnswerSheet1.isCorect4() + ":" + examAnswerSheet1.isCorect5() + ":";
                System.out.println("data =" + data);
                if (bufferedWriter.append(data) != null) {
                    bufferedWriter.flush();
                } else {
                    return false;
                }
                i++;
                System.out.println("i =" + i);
            }
            if (answerList.size() == i) {
                return true;
            }
            return false;
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    @Override
    public boolean isDeleteExamAnswerSheet(String exam_id) throws RemoteException, IOException {
//        try {
//            rwLock.writeLock().lock();
//        } finally {
//            rwLock.writeLock().unlock();
//        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUpdateExamAnswerSheet(String exam_id) throws RemoteException, IOException {
//        try {
//            rwLock.writeLock().lock();
//        } finally {
//            rwLock.writeLock().unlock();
//        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExamAnswerSheet searchExamAnswerSheet(String type, String key) throws RemoteException, IOException {
//        try {
//            rwLock.readLock().lock();
//        } finally {
//            rwLock.readLock().unlock();
//        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ExamAnswerSheet> getAllExamAnswerSheet(String exam_id) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            file = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\exam\\" + exam_id + ".txt");
            fileReader = new FileReader(file);
            ArrayList<ExamAnswerSheet> answerList2 = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 5 == 0) {
                        ExamAnswerSheet examAnswerSheet = new ExamAnswerSheet(exam_id, Boolean.parseBoolean(split[i]), Boolean.parseBoolean(split[i + 1]), Boolean.parseBoolean(split[i + 2]), Boolean.parseBoolean(split[i + 3]), Boolean.parseBoolean(split[i + 4]));
                        answerList2.add(examAnswerSheet);
                    }
                }
            }
            return answerList2;
        } finally {
            rwLock.readLock().unlock();
        }

    }

}
