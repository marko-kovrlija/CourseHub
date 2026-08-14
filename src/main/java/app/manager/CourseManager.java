package app.manager;

import app.model.Course;
import app.model.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class CourseManager {

    private HashMap<String, Student> students;
    private HashMap<Integer, Course> courses;

    public CourseManager() {
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    public boolean addCourse(Course course){
        if(courses.containsKey(course.getId())){
            return false;
        }

        courses.put(course.getId(), course);
        return true;
    }

    public boolean removeCourse(Course course){
        return courses.remove(course.getId(), course);
    }

    public Course findCourse(String name){
        for(Course c : courses.values()){
            if(c.getName().equals(name)){
                return c;
            }
        }

        return null;
    }

    public boolean addStudent(Student student){
        if(students.containsKey(student.getEmail())){
            return false;
        }

        students.put(student.getEmail(), student);
        return true;
    }

    public boolean removeStudent(Student student){
        if(students.containsKey(student.getEmail())){
            students.remove(student.getEmail());
            return true;
        }

        return false;
    }

    public Student findStudent(String email){
        return students.get(email);
    }

    public boolean enrollStudent(Student student, Course course){
        if(course.getStudents().contains(student)){
            return false;
        }

        if(!students.containsKey(student.getEmail()) || !courses.containsKey(course.getId())){
            return false;
        }

        if(course.getStudents().size() >= course.getMaxStudents()){
            return false;
        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        return true;
    }

    public boolean cancelEnrollment(Student student, Course course){
        if(course.getStudents().contains(student)){
            student.getCourses().remove(course);
            course.getStudents().remove(student);
            return true;
        }

        return false;
    }
}
