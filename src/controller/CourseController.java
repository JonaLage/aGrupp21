/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Random;
import model.Student;
import view.CreateCourse;
/**
 *
 * @author jackie-sally
 */
public class CourseController {
    private Student studentModel;
    private CreateCourse frame; 

    public CourseController(Student studentModel, CreateCourse frame) {
        this.studentModel = studentModel;
        this.frame = frame;
    }
    
    
    
}
