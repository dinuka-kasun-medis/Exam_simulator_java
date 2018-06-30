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
public class Subject implements Serializable {
    private String subject_id;
    private String name;

    /**
     *
     * @param subject_id
     * @param name
     */
    public Subject(String subject_id, String name) {
        this.subject_id = subject_id;
        this.name = name;
    }

    /**
     * @return the subject_id
     */
    public String getSubject_id() {
        return subject_id;
    }

    /**
     * @param subject_id the subject_id to set
     */
    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
