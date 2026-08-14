package app.manager;

import app.model.Program;
import app.model.Student;
import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ProgramManager {

    private static ProgramManager instance;

    private Map<String, Student> students;
    private Map<Integer, Program> programs;

    private ProgramManager() {
        students = new HashMap<>();
        programs = new HashMap<>();
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
        return true;
    }

    public boolean removeProgram(Program program){
        return programs.remove(program.getId(), program);
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
        return true;
    }

    public boolean cancelEnrollment(Student student, Program program){
        if(program.getStudents().contains(student)){
            student.getPrograms().remove(program);
            program.getStudents().remove(student);
            return true;
        }

        return false;
    }
}
