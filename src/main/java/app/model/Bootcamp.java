package app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bootcamp extends Program{

    private int durationInWeeks;

    public Bootcamp(String name, ProgramCategory category, int maxStudents, int price, int durationInWeeks) {
        super(name, category, maxStudents, price);
        this.durationInWeeks = durationInWeeks;
    }

    @Override
    public String toString() {
        return getName();
    }
}
