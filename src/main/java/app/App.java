package app;

import app.controller.ProgramController;
import app.controller.StudentController;
import app.manager.ProgramManager;
import app.model.Student;
import app.view.MainFrame;
import app.view.ProgramPanel;

public class App {
    static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();

        ProgramController programController = new ProgramController(mainFrame.getProgramPanel());
        StudentController studentController = new StudentController(mainFrame.getStudentPanel());
    }
}
