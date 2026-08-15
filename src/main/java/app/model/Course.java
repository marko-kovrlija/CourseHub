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
        validate();
    }

    @Override
    public String toString() {
        return "Course: " + getName();
    }

    @Override
    protected void validate() {
        if(getName() == null || getName().isBlank()){
            throw new IllegalArgumentException("Bootcamp name cannot be empty!");
        }
        if(getCategory() == null){
            throw new IllegalArgumentException("Bootcamp category cannot be null!");
        }
        if(getMaxStudents() < 1){
            throw new IllegalArgumentException("Bootcamp must have at least one student!");
        }
        if(getPrice() < 0){
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        if(getAmountOfClasses() < 1){
            throw new IllegalArgumentException("Bootcamp nmust have at least 1 class!");
        }
        if(getType() == null){
            throw new IllegalArgumentException("Type cannot be null!");
        }
    }
}
