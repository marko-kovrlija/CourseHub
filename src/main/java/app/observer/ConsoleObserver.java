package app.observer;

public class ConsoleObserver implements ProgramObserver{

    @Override
    public void update(String message) {
        System.out.println("Event: " + message);
    }
}
