package com.stackroute.diagnosticserver.model;

import javax.persistence.*;

// Mark with entity annotation
// Mark with table annotation
@Entity
@Table(name = "diagnostic")
public class Diagnostic {

    // This class should have four fields (testId, name, descriptio, price) with testId as the primary key
    // generate value for testId
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diagnostic_generator")
    private int testId;
    private String name;
    private String description;
    private double price;

    // no-arg constructor
    public Diagnostic() {
    }

    // parameterized constructor
    public Diagnostic(int testId, String name, String description, double price) {
        this.testId = testId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //Getter and Setter
    public int getId() {
        return testId;
    }

    public void setId(int testId) {
        this.testId= testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
