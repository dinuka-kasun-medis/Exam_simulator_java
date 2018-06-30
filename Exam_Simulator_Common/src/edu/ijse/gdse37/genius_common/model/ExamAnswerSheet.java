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
public class ExamAnswerSheet implements Serializable{
    private String exam_id;
    private boolean corect1;
    private boolean corect2;
    private boolean corect3;
    private boolean corect4;
    private boolean corect5;

    /**
     *
     * @param exam_id
     * @param corect1
     * @param corect2
     * @param corect3
     * @param corect4
     * @param corect5
     */
    public ExamAnswerSheet(String exam_id, boolean corect1, boolean corect2, boolean corect3, boolean corect4, boolean corect5) {
        this.exam_id = exam_id;
        this.corect1 = corect1;
        this.corect2 = corect2;
        this.corect3 = corect3;
        this.corect4 = corect4;
        this.corect5 = corect5;
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
     * @return the corect1
     */
    public boolean isCorect1() {
        return corect1;
    }

    /**
     * @param corect1 the corect1 to set
     */
    public void setCorect1(boolean corect1) {
        this.corect1 = corect1;
    }

    /**
     * @return the corect2
     */
    public boolean isCorect2() {
        return corect2;
    }

    /**
     * @param corect2 the corect2 to set
     */
    public void setCorect2(boolean corect2) {
        this.corect2 = corect2;
    }

    /**
     * @return the corect3
     */
    public boolean isCorect3() {
        return corect3;
    }

    /**
     * @param corect3 the corect3 to set
     */
    public void setCorect3(boolean corect3) {
        this.corect3 = corect3;
    }

    /**
     * @return the corect4
     */
    public boolean isCorect4() {
        return corect4;
    }

    /**
     * @param corect4 the corect4 to set
     */
    public void setCorect4(boolean corect4) {
        this.corect4 = corect4;
    }

    /**
     * @return the corect5
     */
    public boolean isCorect5() {
        return corect5;
    }

    /**
     * @param corect5 the corect5 to set
     */
    public void setCorect5(boolean corect5) {
        this.corect5 = corect5;
    }
}
