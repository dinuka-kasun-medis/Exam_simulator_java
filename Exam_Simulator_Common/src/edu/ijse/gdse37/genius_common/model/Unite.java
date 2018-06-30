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
public class Unite implements Serializable {
    private String unit_id;
    private String subject_id;
    private String name;

    /**
     *
     * @param unit_id
     * @param subject_id
     * @param name
     */
    public Unite(String unit_id, String subject_id, String name) {
        this.unit_id = unit_id;
        this.subject_id = subject_id;
        this.name = name;
    }

    /**
     * @return the unit_id
     */
    public String getUnit_id() {
        return unit_id;
    }

    /**
     * @param unit_id the unit_id to set
     */
    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
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
