package app.controller;

import lombok.Getter;

@Getter
public class StudentController {

    private StudentController studentController;

    public StudentController(StudentController studentController) {
        this.studentController = studentController;
        setupListeners();
    }

    private void setupListeners(){

    }
}
