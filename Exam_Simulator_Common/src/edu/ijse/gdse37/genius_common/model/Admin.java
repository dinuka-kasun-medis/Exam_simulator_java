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
public class Admin implements Serializable{
    private String admin_id;
    private String name;
    private String email;
    private int telephone;
    private String password;
    private String nic;

    /**
     *
     * @param admin_id
     * @param name
     * @param email
     * @param telephone
     * @param password
     * @param nic
     */
    public Admin(String admin_id, String name, String email, int telephone, String password, String nic) {
        this.admin_id = admin_id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.nic = nic;
    }

    /**
     * @return the admin_id
     */
    public String getAdmin_id() {
        return admin_id;
    }

    /**
     * @param admin_id the admin_id to set
     */
    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }
    
}
