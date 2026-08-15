package app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public abstract class Program {

    private int id;
    private static int nextId = 1;
    private String name;
    private ProgramCategory category;
    private int maxStudents;
    private int price;
    private List<Student> students;

    public Program(String name, ProgramCategory category, int maxStudents, int price) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.maxStudents = maxStudents;
        this.price = price;
        students = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    protected abstract void validate();
}
