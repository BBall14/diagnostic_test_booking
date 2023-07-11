package com.stackroute.diagnosticserver.model;

import javax.persistence.*;

// This class will be used to create the user table in the database

@Entity
@Table(name="users")
public class User {

    // This class should have three fields (patientId, username, password) with patientId as the primary key
    // generate value for patientId
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_generator")
    private int patientId;
    private String userName;
    private String password;

    public User() {
    }

    public User(int patientId, String userName, String password) {
        this.patientId = patientId;
        this.userName = userName;
        this.password = password;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
