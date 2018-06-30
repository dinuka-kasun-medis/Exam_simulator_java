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
public class Exam implements Serializable{
    private String exam_id;
    private String exam_name;
    private String subject;
    private String unite;
    private int no_of_questions;
    private String content;

    /**
     *
     * @param exam_id
     * @param exam_name
     * @param subject
     * @param unite
     * @param no_of_questions
     * @param content
     */
    public Exam(String exam_id, String exam_name, String subject, String unite, int no_of_questions, String content) {
        this.exam_id = exam_id;
        this.exam_name = exam_name;
        this.subject = subject;
        this.unite = unite;
        this.no_of_questions = no_of_questions;
        this.content = content;
        
    }

    /**
     * @return the exam_id
     */
    public String getExam_id() {
        return exam_id;
    }

    /**
     * @param exam_id the exam_id to set
     */
    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    /**
     * @return the exam_name
     */
    public String getExam_name() {
        return exam_name;
    }

    /**
     * @param exam_name the exam_name to set
     */
    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
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
     * @return the unite
     */
    public String getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * @return the no_of_questions
     */
    public int getNo_of_questions() {
        return no_of_questions;
    }

    /**
     * @param no_of_questions the no_of_questions to set
     */
    public void setNo_of_questions(int no_of_questions) {
        this.no_of_questions = no_of_questions;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}