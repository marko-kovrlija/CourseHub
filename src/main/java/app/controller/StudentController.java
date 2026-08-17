package app.controller;

import app.view.StudentPanel;
import lombok.Getter;

@Getter
public class StudentController {

    private StudentPanel studentPanel;

    public StudentController(StudentPanel studentPanel) {
        this.studentPanel = studentPanel;
        setupListeners();
    }

    private void setupListeners(){

    }
}
