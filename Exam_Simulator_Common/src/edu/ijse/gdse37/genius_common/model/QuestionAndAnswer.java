/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse37.genius_common.model;

import java.io.Serializable;

/**
 *
 * @author Dinuka
 */
public class QuestionAndAnswer implements Serializable {
    private String question_id;
    private String subject;
    private String unit;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private boolean correct1;
    private boolean correct2;
    private boolean correct3;
    private boolean correct4;
    private boolean correct5;

    /**
     *
     * @param question_id
     * @param subject
     * @param unit
     * @param question
     * @param answer1
     * @param answer2
     * @param answer3
     * @param answer4
     * @param answer5
     * @param correct1
     * @param correct2
     * @param correct3
     * @param correct4
     * @param correct5
     */
    public QuestionAndAnswer(String question_id, String subject, String unit, String question, String answer1, String answer2, String answer3, String answer4, String answer5, boolean correct1, boolean correct2, boolean correct3, boolean correct4, boolean correct5) {
        this.question_id = question_id;
        this.subject = subject;
        this.unit = unit;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.correct1 = correct1;
        this.correct2 = correct2;
        this.correct3 = correct3;
        this.correct4 = correct4;
        this.correct5 = correct5;
    }

    /**
     * @return the question_id
     */
    public String getQuestion_id() {
        return question_id;
    }

    /**
     * @param question_id the question_id to set
     */
    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answer1
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * @param answer1 the answer1 to set
     */
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    /**
     * @return the answer2
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * @param answer2 the answer2 to set
     */
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    /**
     * @return the answer3
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * @param answer3 the answer3 to set
     */
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    /**
     * @return the answer4
     */
    public String getAnswer4() {
        return answer4;
    }

    /**
     * @param answer4 the answer4 to set
     */
    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    /**
     * @return the answer5
     */
    public String getAnswer5() {
        return answer5;
    }

    /**
     * @param answer5 the answer5 to set
     */
    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    /**
     * @return the correct1
     */
    public boolean isCorrect1() {
        return correct1;
    }

    /**
     * @param correct1 the correct1 to set
     */
    public void setCorrect1(boolean correct1) {
        this.correct1 = correct1;
    }

    /**
     * @return the correct2
     */
    public boolean isCorrect2() {
        return correct2;
    }

    /**
     * @param correct2 the correct2 to set
     */
    public void setCorrect2(boolean correct2) {
        this.correct2 = correct2;
    }

    /**
     * @return the correct3
     */
    public boolean isCorrect3() {
        return correct3;
    }

    /**
     * @param correct3 the correct3 to set
     */
    public void setCorrect3(boolean correct3) {
        this.correct3 = correct3;
    }

    /**
     * @return the correct4
     */
    public boolean isCorrect4() {
        return correct4;
    }

    /**
     * @param correct4 the correct4 to set
     */
    public void setCorrect4(boolean correct4) {
        this.correct4 = correct4;
    }

    /**
     * @return the correct5
     */
    public boolean isCorrect5() {
        return correct5;
    }

    /**
     * @param correct5 the correct5 to set
     */
    public void setCorrect5(boolean correct5) {
        this.correct5 = correct5;
    }
  
}
