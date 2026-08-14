package app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course extends Program{

    private int amountOfClasses;
    private CourseType type;

    public Course(String name, ProgramCategory category, int maxStudents, int price, int amountOfClasses, CourseType type) {
        super(name, category, maxStudents, price);
        this.amountOfClasses = amountOfClasses;
        this.type = type;
    }

    @Override
    public String toString() {
        return getName();
    }
}
