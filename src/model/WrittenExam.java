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
public class WrittenExam {
    private String examID;
    private String date;
    private String location;
    private String time;
    private int maxPoints; 
    private Course course; 
    private ArrayList<Student> students = new ArrayList<Student>();

    public WrittenExam(String examID, String date, String location, String time, int maxPoints) {
        this.examID = examID;
        this.date = date;
        this.location = location;
        this.time = time;
        this.maxPoints = maxPoints;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getExamID() {
        return examID;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    /**
	 * Add a student to the exam if not already there
	 *  @param student student to add
	 *  @return whether student was added
	 */
	public boolean add(Student student){

		if (!students.contains(student)){
			students.add(student);
			return true;
		}
		return false;
	}
    
}
