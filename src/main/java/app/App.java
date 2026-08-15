package app;

import app.factory.ProgramFactory;
import app.manager.ProgramManager;
import app.model.Bootcamp;
import app.model.Course;
import app.model.CourseType;
import app.model.ProgramCategory;
import app.view.MainFrame;

public class App {
    static void main(String[] args) {

        ProgramManager manager = ProgramManager.getInstance();

        Course java = ProgramFactory.createProgram(
                "Java OOP",
                ProgramCategory.PROGRAMMING,
                20,
                12000,
                30, CourseType.ONLINE
        );

        Bootcamp backend = ProgramFactory.createProgram(
                "Java Backend",
                ProgramCategory.PROGRAMMING,
                15,
                50000,
                12
        );

        manager.addProgram(java);
        manager.addProgram(backend);

        MainFrame mainFrame = new MainFrame();

        new MainFrame();

        manager.addProgram(
                new Course(
                        "Python Advanced",
                        ProgramCategory.PROGRAMMING,
                        20,
                        15000,
                        30,
                        CourseType.ONLINE
                )
        );

    }
}
