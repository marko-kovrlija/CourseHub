package app.view;

import app.manager.ProgramManager;
import app.model.Program;
import app.observer.ProgramObserver;

import javax.swing.*;
import java.awt.*;

public class ProgramPanel extends JPanel implements ProgramObserver {

    private DefaultListModel<Program> programModel;
    private JList<Program> programList;

    public ProgramPanel() {
        programModel = new DefaultListModel<>();
        programList = new JList<>(programModel);
        refreshProgramList();
        ProgramManager.getInstance().getObservers().add(this);
        add(programList);
    }

    void refreshProgramList(){
        programModel.clear();
        for(Program program : ProgramManager.getInstance().getPrograms().values()){
            programModel.addElement(program);
        }
    }

    @Override
    public void update(String message) {
        refreshProgramList();
    }
}
