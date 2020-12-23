/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author jackie-sally
 */
public class Student {
    private String studentID; 
    private String firstName; 
    private String lastName; 
    private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();

    public Student(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ArrayList<WrittenExam> getWrittenExams() {
        return writtenExams;
    }

    public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
        this.writtenExams = writtenExams;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }
     /**
     * Set a student's First Name.
     * The first name should only consist of letters (a-z, A-z), dashes (-) or spaces ( )
     * @param firstName First Name
     * @throws IllegalArgumentException  Thrown if the first name is empty, or contains illegal characters
     */
    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || !firstName.replaceAll("[^a-zA-Z -]", "").equals(firstName) || firstName.trim().equals("")) {
            throw new IllegalArgumentException("You must enter a valid first name, consisting only of alphabetical and spaces.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    /**
     * Set a student's Last Name.
     * The last name should only consist of letters (a-z, A-z), dashes (-) or spaces ( )
     * @param lastName Last Name
     * @throws IllegalArgumentException  Thrown if the last name is empty, or contains illegal characters
     */
    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || !lastName.replaceAll("[^a-zA-Z -]", "").equals(lastName) || lastName.trim().equals("")) {
            throw new IllegalArgumentException("You must enter a valid last name, consisting only of alphabetical and spaces.");
        }
        this.lastName = lastName;
    } 
    
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
