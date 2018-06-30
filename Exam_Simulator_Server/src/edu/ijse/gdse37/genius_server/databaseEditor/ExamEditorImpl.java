/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template EXAM_FOLDER, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.ExamEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.Exam;
import edu.ijse.gdse37.genius_common.model.ExamAnswerSheet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write Exam details
 * @author Dinuka
 */
public class ExamEditorImpl implements ExamEditor {

    private final File EXAM_FOLDER = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\" + "exam");
    private File file1 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\exam\\exam.txt");
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static ExamAnswerSheetEditorImpl examAnswerSheetEditorImpl = new ExamAnswerSheetEditorImpl();
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     *
     * @param exam
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddExam(Exam exam, ArrayList<ExamAnswerSheet> examAnswerSheetList) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            EXAM_FOLDER.mkdir();
            fileWriter = new FileWriter(file1, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = exam.getExam_id() + ":" + exam.getExam_name() + ":" + exam.getSubject() + ":"
                    + exam.getUnite() + ":" + exam.getNo_of_questions() + ":" + exam.getContent() + ":";
            if (bufferedWriter.append(data) != null) {
                bufferedWriter.close();
                if (examAnswerSheetEditorImpl.isAddExamAnswerSheet(exam.getExam_id(), examAnswerSheetList)) {
                    return true;
                } else {
                    return true;
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
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isDeleteExam(String exam_id) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param exam_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateExam(String exam_id) throws RemoteException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Exam searchExam(String type, String key) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            Exam exam = null;
            if (file1.exists()) {
                fileReader = new FileReader(file1);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    if ("exam_id".equals(type)) {
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].equals(key)) {
                                exam = new Exam(split[i], split[i + 1], split[i + 2], split[i + 3],
                                        Integer.parseInt(split[i + 4]), split[i + 5]
                                );
                            }
                        }
                    }
                    //other type
                }
            }
            return exam;
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
    public ArrayList<Exam> getAllExam() throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            ArrayList<Exam> examList = new ArrayList<>();
            if (file1.exists()) {
                fileReader = new FileReader(file1);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    for (int i = 0; i < split.length - 1; i++) {
                        if (i % 6 == 0) {
                            Exam exam = new Exam(split[i], split[i + 1], split[i + 2], split[i + 3],
                                    Integer.parseInt(split[i + 4]), split[i + 5]
                            );
                            examList.add(exam);
                        }
                    }
                }

            }
            return examList;
        } finally {
            rwLock.readLock().unlock();
        }

    }

}
