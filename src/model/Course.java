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
public class Course {
    private String courseCode; 
    private String name;
    private int credit; 
    //The list of exams in the course is maintained using an ArrayList
    private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();
    private static int  count;
    
    //Creates a course with a generated coursecode, name and credit
    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
        addCount();
    }
    
   
    public ArrayList<WrittenExam> getWrittenExams() {
        return writtenExams;
    }

    public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
        this.writtenExams = writtenExams;
    }

    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode() {
        if(count<10)
      courseCode ="0000"+count;
    else if(count>9&&count<100)
      courseCode="000"+count;
    else if(count>99&&count<1000)
      courseCode="00"+count;
    else if(count>999&&count<10000)
      courseCode="0"+count;
    else if(count>9999&&count<100000)
      courseCode=""+count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public boolean equals(Course course){
        if(this.credit == course.credit && this.name.equals(course.name)){
            return true;
        }
        else{
            return false; 
        }
      
    }
    
    /**
   *Increments automatically everytime a student object has been created and
   *generates an ID Number for that student.
   */
    private void addCount() {
        count++;
        setCourseCode(); 
     }
    
    /**
     *Sets and initial value of how many Students has been previously created.
     *@param newCount New initial count.
     */
    public  static void setInitialCount(int newCount){
     count = newCount;
    }
    /**
     *Sets a new ID Number for the student created.
     *@param thisNew The new ID Number to be initialized.
     */
    public  void setNewCourseCode(String thisNew){
        courseCode = thisNew;
  }
    /**
	 * Add a written exam to the course if not already there
	 *  @param writtenexam exam to add
	 *  @return whether exam was added
	 */
	public boolean add(WrittenExam exam){

		if (!writtenExams.contains(exam)){
			writtenExams.add(exam);
			return true;
		}
		return false;
	}
    /**
	 * remove an exam from the course
	 * @param exam to remove
	 */
	public void remove(WrittenExam exam){
		writtenExams.remove(exam);
	}
	
	/**
	 * removes the exam with index i
	 * @param i: index of exam to remove
	 */
	public void remove(int i){
		writtenExams.remove(i);
	}
        /**
	 * returns the student with index i in the database
	 * @param i
	 * @return get the student with index i
	 */
	public WrittenExam getWrittenExams(int i){
		return writtenExams.get(i);
	}
        /**
	 * searches for a student 
	 * @param student a student object
	 * @return the index at which a student occurs in the database
	 */
	
	public int indexOf(WrittenExam exam){
		return writtenExams.indexOf(exam);
	}
        
        public boolean contains(WrittenExam exam) {
		return writtenExams.contains(exam);
	}
        
        /**
     *Returns Student Informations.
     *@return Student ID Number and full name.
     */
    public  String toString(){
        return getCourseCode()+" "+super.toString();
  }
}
