/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.WrittenExam;
import view.CreateExam;

/**
 *
 * @author jackie-sally
 */
public class ExamController {
    private WrittenExam model;
    private CreateExam frame; 

    public ExamController(WrittenExam model, CreateExam frame) {
        this.model = model;
        this.frame = frame;
    }
}
