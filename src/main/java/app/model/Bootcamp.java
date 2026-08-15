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
        validate();
    }

    @Override
    public String toString() {
        return "Bootcamp: " + getName();
    }

    @Override
    protected void validate() {
        if(getName() == null || getName().isBlank()){
            throw new IllegalArgumentException("Course name cannot be empty!");
        }
        if(getCategory() == null){
            throw new IllegalArgumentException("Course category cannot be null!");
        }
        if(getMaxStudents() < 1){
            throw new IllegalArgumentException("Course must have at least one student!");
        }
        if(getPrice() < 0){
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        if(getDurationInWeeks() < 1){
            throw new IllegalArgumentException("Bootcamp must have at least one week!");
        }
    }
}
