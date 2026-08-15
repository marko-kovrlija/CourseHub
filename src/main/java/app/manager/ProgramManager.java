package app.manager;

import app.model.Program;
import app.model.Student;
import app.observer.ProgramObserver;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ProgramManager {

    private static ProgramManager instance;

    private Map<String, Student> students;
    private Map<Integer, Program> programs;
    private List<ProgramObserver> observers;

    private ProgramManager() {
        students = new HashMap<>();
        programs = new HashMap<>();
        observers = new ArrayList<>();
    }

    public static ProgramManager getInstance(){
        if(instance == null){
            instance = new ProgramManager();
        }
        return instance;
    }

    public boolean addProgram(Program program){
        if(programs.containsKey(program.getId())){
            return false;
        }

        programs.put(program.getId(), program);
        notifyObservers("Program added: " + program.getName());
        return true;
    }

    public boolean removeProgram(Program program){
        boolean removed = programs.remove(program.getId(), program);

        if(removed){
            notifyObservers("Program removed: " + program.getName());
        }

        return removed;
    }

    public Program findProgram(String name){
        for(Program c : programs.values()){
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
        notifyObservers("Student added: " + student.getName());
        return true;
    }

    public boolean removeStudent(Student student){
        if(students.containsKey(student.getEmail())){
            students.remove(student.getEmail());
            notifyObservers("Student removed: " + student.getName());
            return true;
        }

        return false;
    }

    public Student findStudent(String email){
        return students.get(email);
    }

    public boolean enrollStudent(Student student, Program program){
        if(program.getStudents().contains(student)){
            return false;
        }

        if(!students.containsKey(student.getEmail()) || !programs.containsKey(program.getId())){
            return false;
        }

        if(program.getStudents().size() >= program.getMaxStudents()){
            return false;
        }

        student.getPrograms().add(program);
        program.getStudents().add(student);

        notifyObservers(
                student.getName() + " enrolled in " + program.getName()
        );

        return true;
    }

    public boolean cancelEnrollment(Student student, Program program){
        if(program.getStudents().contains(student)){
            student.getPrograms().remove(program);
            program.getStudents().remove(student);
            return true;
        }

        notifyObservers(
                student.getName() + " cancelled enrollment in " + program.getName()
        );

        return false;
    }

    public void addObserver(ProgramObserver programObserver){
        observers.add(programObserver);
    }

    public void removeObserver(ProgramObserver programObserver){
        observers.remove(programObserver);
    }

    private void notifyObservers(String message) {
        for (ProgramObserver observer : observers) {
            observer.update(message);
        }
    }
}
