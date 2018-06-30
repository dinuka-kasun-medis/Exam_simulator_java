/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_server.databaseEditor;

import edu.ijse.gdse37.genius_common.databaseEditor.QuestionAndAnswerEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.ijse.gdse37.genius_common.model.QuestionAndAnswer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * For read and write Questions and Answers details
 * @author Dinuka
 */
public class QuestionAndAnswerEditorImpl implements QuestionAndAnswerEditor {

    private File file = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\Question.txt");
    private File file1;
    private File file2;
    private File file3;
    private FileWriter fileWriter;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String data;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isAddQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            file1 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\question");
            file1.mkdir();
            file3 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\question\\" + questionAndAnswer.getSubject() + ".txt");
            fileWriter = new FileWriter(file3, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            data = questionAndAnswer.getQuestion_id() + ":" + questionAndAnswer.getSubject() + ":" + questionAndAnswer.getUnit() + ":"
                    + questionAndAnswer.getQuestion() + ":" + questionAndAnswer.getAnswer1() + ":" + questionAndAnswer.getAnswer2() + ":"
                    + questionAndAnswer.getAnswer3() + ":" + questionAndAnswer.getAnswer4() + ":" + questionAndAnswer.getAnswer5() + ":"
                    + questionAndAnswer.isCorrect1() + ":" + questionAndAnswer.isCorrect2() + ":" + questionAndAnswer.isCorrect3() + ":"
                    + questionAndAnswer.isCorrect4() + ":" + questionAndAnswer.isCorrect5() + ":";
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
     * @param questionAndAnswer
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public boolean isUpdateQuestionAndAnswer(QuestionAndAnswer questionAndAnswer) throws RemoteException, IOException {
        try {
            System.out.println("start");
            rwLock.writeLock().lock();
            String[] questionAndAnswerList = null;
            file3 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\question\\" + questionAndAnswer.getSubject() + ".txt");
            if (file3.exists()) {
                fileReader = new FileReader(file3);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    questionAndAnswerList = data.split(":");
                }
            }
            int updated = 0;
            for (int i = 0; i < questionAndAnswerList.length; i++) {
                if (questionAndAnswerList[i].equals(questionAndAnswer.getQuestion_id())) {
                    updated = i;
                    System.out.println("i ="+i);
                    questionAndAnswerList[i] = questionAndAnswer.getQuestion_id();
                    questionAndAnswerList[i + 1] = questionAndAnswer.getSubject();
                    questionAndAnswerList[i + 2] = questionAndAnswer.getUnit();
                    questionAndAnswerList[i + 3] = questionAndAnswer.getQuestion();
                    questionAndAnswerList[i + 4] = questionAndAnswer.getAnswer1();
                    questionAndAnswerList[i + 5] = questionAndAnswer.getAnswer2();
                    questionAndAnswerList[i + 6] = questionAndAnswer.getAnswer3();
                    questionAndAnswerList[i + 7] = questionAndAnswer.getAnswer4();
                    questionAndAnswerList[i + 8] = questionAndAnswer.getAnswer5();
                    questionAndAnswerList[i + 9] = Boolean.toString(questionAndAnswer.isCorrect1());
                    questionAndAnswerList[i + 10] = Boolean.toString(questionAndAnswer.isCorrect2());
                    questionAndAnswerList[i + 11] = Boolean.toString(questionAndAnswer.isCorrect3());
                    questionAndAnswerList[i + 12] = Boolean.toString(questionAndAnswer.isCorrect4());
                    questionAndAnswerList[i + 13] = Boolean.toString(questionAndAnswer.isCorrect5());
                    i += 13;
                }
            }
            fileWriter = new FileWriter(file3, false);
            for (int i = 0; i < questionAndAnswerList.length; i++) {
                fileWriter.write(questionAndAnswerList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(file3);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            String[] newQuestionAndAnswerList = data.split(":");
            if (questionAndAnswerList.length == newQuestionAndAnswerList.length) {
                if (newQuestionAndAnswerList[updated].equals(questionAndAnswer.getQuestion_id())) {
                    if (newQuestionAndAnswerList[updated + 1].equals(questionAndAnswer.getSubject())) {
                        if (newQuestionAndAnswerList[updated + 2].equals(questionAndAnswer.getUnit())) {
                            if (newQuestionAndAnswerList[updated + 3].equals(questionAndAnswer.getQuestion())) {
                                if (newQuestionAndAnswerList[updated + 4].equals(questionAndAnswer.getAnswer1())) {
                                    if (newQuestionAndAnswerList[updated + 5].equals(questionAndAnswer.getAnswer2())) {
                                        if (newQuestionAndAnswerList[updated + 6].equals(questionAndAnswer.getAnswer3())) {
                                            if (newQuestionAndAnswerList[updated + 7].equals(questionAndAnswer.getAnswer4())) {
                                                if (newQuestionAndAnswerList[updated + 8].equals(questionAndAnswer.getAnswer5())) {
                                                    if (newQuestionAndAnswerList[updated + 9].equals(Boolean.toString(questionAndAnswer.isCorrect1()))) {
                                                        if (newQuestionAndAnswerList[updated + 10].equals(Boolean.toString(questionAndAnswer.isCorrect2()))) {
                                                            if (newQuestionAndAnswerList[updated + 11].equals(Boolean.toString(questionAndAnswer.isCorrect3()))) {
                                                                if (newQuestionAndAnswerList[updated + 12].equals(Boolean.toString(questionAndAnswer.isCorrect4()))) {
                                                                    if (newQuestionAndAnswerList[updated + 13].equals(Boolean.toString(questionAndAnswer.isCorrect5()))) {
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
            } else {
                return false;
            }
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    /**
     *
     * @param subject
     * @param unite
     * @param question_id
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override//modify
    public boolean isDeleteQuestionAndAnswer(String subject, String unite, String question_id) throws RemoteException, IOException {
        try {
            rwLock.writeLock().lock();
            String[] questionAndAnswerList = null;
            file3 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\question\\" + subject + ".txt");
            if (file3.exists()) {
                fileReader = new FileReader(file3);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    questionAndAnswerList = data.split(":");
                }
            }
            String[] newQuestionAndAnswerList = new String[questionAndAnswerList.length -13];
            for (int i = 0, j = 0; i < questionAndAnswerList.length; i++) {
                if (questionAndAnswerList[i].equals(question_id)) {
                    i += 13;
                } else {
                    newQuestionAndAnswerList[j] = questionAndAnswerList[i];
                    j++;
                }
            }
            fileWriter = new FileWriter(file3, false);
            for (int i = 0; i < newQuestionAndAnswerList.length; i++) {
                fileWriter.write(newQuestionAndAnswerList[i] + ":");
                fileWriter.flush();
            }
            fileReader = new FileReader(file3);
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            newQuestionAndAnswerList = data.split(":");
            if (questionAndAnswerList.length != newQuestionAndAnswerList.length) {
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
     * @param subject
     * @param unite
     * @param type
     * @param key
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public QuestionAndAnswer searchQuestionAndAnswer(String subject, String unite, String type, String key) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            QuestionAndAnswer questionAndAnswer = null;
            file3 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\question\\" + subject + ".txt");
            if (file3.exists()) {
                fileReader = new FileReader(file3);
                bufferedReader = new BufferedReader(fileReader);
                data = bufferedReader.readLine();
                if (data != null) {
                    String[] split = data.split(":");
                    if ("question_id".equals(type)) {
                        for (int i = 0; i < split.length; i++) {
                            if (split[i].equals(key)) {
                                questionAndAnswer = new QuestionAndAnswer(split[i], split[i + 1], split[i + 2],
                                        split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8],
                                        Boolean.parseBoolean(split[i + 9]), Boolean.parseBoolean(split[i + 10]),
                                        Boolean.parseBoolean(split[i + 11]), Boolean.parseBoolean(split[i + 12]),
                                        Boolean.parseBoolean(split[i + 13]));
                            }
                        }
                    }
                    ///other type
                }
            }
            return questionAndAnswer;
        } finally {
            rwLock.readLock().unlock();
        }

    }

    /**
     *
     * @param subject
     * @param unite
     * @return
     * @throws RemoteException
     * @throws IOException
     */
    @Override
    public ArrayList<QuestionAndAnswer> getAllQuestionAndAnswers(String subject, String unite) throws RemoteException, IOException {
        try {
            rwLock.readLock().lock();
            file3 = new File("src\\edu\\ijse\\gdse37\\genius_server\\database\\question\\" + subject + ".txt");
            fileReader = new FileReader(file3);
            ArrayList<QuestionAndAnswer> questionAndAnswerList = new ArrayList<>();
            bufferedReader = new BufferedReader(fileReader);
            data = bufferedReader.readLine();
            if (data != null) {
                String[] split = data.split(":");
                for (int i = 0; i < split.length - 1; i++) {
                    if (i % 14 == 0) {
                        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer(split[i], split[i + 1], split[i + 2],
                                split[i + 3], split[i + 4], split[i + 5], split[i + 6], split[i + 7], split[i + 8],
                                Boolean.parseBoolean(split[i + 9]), Boolean.parseBoolean(split[i + 10]),
                                Boolean.parseBoolean(split[i + 11]), Boolean.parseBoolean(split[i + 12]),
                                Boolean.parseBoolean(split[i + 13]));
                        if (split[i + 2].equals(unite)) {
                            questionAndAnswerList.add(questionAndAnswer);
                        }
                        if (unite.equals("All")) {
                            questionAndAnswerList.add(questionAndAnswer);
                        }
                    }
                }
            }
            return questionAndAnswerList;
        } finally {
            rwLock.readLock().unlock();
        }

    }
}
