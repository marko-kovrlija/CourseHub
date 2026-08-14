package app.factory;

import app.model.Bootcamp;
import app.model.Course;
import app.model.CourseType;
import app.model.ProgramCategory;

public class ProgramFactory {

    public static Course createProgram(String name, ProgramCategory category, int maxStudents, int price, CourseType type, int amountOfClasses){
        return new Course(name, category, maxStudents, price, amountOfClasses, type);
    }

    public static Bootcamp createProgram(String name, ProgramCategory category, int maxStudents, int price, int durationInWeeks){
        return new Bootcamp(name, category, maxStudents, price, durationInWeeks);
    }

}
