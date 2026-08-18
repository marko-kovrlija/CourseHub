package app.controller;

import app.manager.ProgramManager;
import app.model.Student;
import app.view.StudentBtnPanel;
import app.view.StudentDialog;
import app.view.StudentFormPanel;
import app.view.StudentPanel;
import lombok.Getter;

import javax.swing.*;

@Getter
public class StudentController {

    private StudentPanel studentPanel;

    public StudentController(StudentPanel studentPanel) {
        this.studentPanel = studentPanel;
        setupListeners();
    }

    private void setupListeners(){
        studentPanel.getBtnAdd().addActionListener(e->{
            StudentDialog studentDialog = new StudentDialog();
            StudentFormPanel studentFormPanel = studentDialog.getStudentFormPanel();

            studentDialog.getStudentBtnPanel().getBtnCreate().addActionListener(addEvent->{
                String name = studentFormPanel.getName();
                String surname = studentFormPanel.getSurname();
                String email = studentFormPanel.getEmail();

                Student s = null;

                try{
                    s = new Student(name, surname, email);
                    ProgramManager.getInstance().addStudent(s);
                    studentDialog.dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(
                            studentDialog,
                            ex.getMessage(),
                            "Invalid info",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            });

            studentDialog.setVisible(true);
        });
    }
}
