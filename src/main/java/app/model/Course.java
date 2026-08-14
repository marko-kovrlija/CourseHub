package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Course {

    private int id;
    private static int nextId = 1;
    private String name;
    private CourseType type;
    private CourseCategory category;
    private int maxStudents;
    private int amountOfClasses;
    private int price;
    private List<Student> students;

    public Course(String name, CourseType type, CourseCategory category, int maxStudents, int amountOfClasses, int price) {
        this.id = nextId++;
        this.name = name;
        this.type = type;
        this.category = category;
        this.maxStudents = maxStudents;
        this.amountOfClasses = amountOfClasses;
        this.price = price;
        students = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return name + " " + type + " " + category + " " + maxStudents + " " + amountOfClasses + " " + price;
    }
}
