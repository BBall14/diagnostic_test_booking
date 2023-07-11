package com.stackroute.diagnosticserver.model;

import com.fasterxml.jackson.databind.DatabindException;

import javax.persistence.*;
import java.util.Date;

// Mark with entity annotation
// Mark with table annotation
@Entity
@Table(name = "appointment")
public class Appointment {

    // This class should have four fields (bookId, patientId, testId, date) with bookId as the primary key
    // generate value for bookId
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_generator")
    private int bookId;
    private int patientId;
    private int testId;
    private String date;

    // no-arg constructor
    public Appointment() {
    }

    // parameterized constructor
    public Appointment(int bookId, int patientId, int testId, String date) {
        this.bookId = bookId;
        this.patientId = patientId;
        this.testId = testId;
        this.date = date;
    }

    // getter and setter methods
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
