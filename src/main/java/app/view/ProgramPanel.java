package app.view;

import app.manager.ProgramManager;
import app.model.Program;
import app.observer.ProgramObserver;

import javax.swing.*;
import java.awt.*;

public class ProgramPanel extends JPanel implements ProgramObserver {

    private DefaultListModel<Program> programModel;
    private JList<Program> programList;
    private JButton btnAdd;

    public ProgramPanel() {
        setLayout(new BorderLayout());

        programModel = new DefaultListModel<>();
        programList = new JList<>(programModel);
        btnAdd = new JButton("Add program");
        btnAddEvent();

        refreshProgramList();

        JScrollPane scrollPane = new JScrollPane(programList);

        ProgramManager.getInstance().addObserver(this);
        add(scrollPane, BorderLayout.CENTER);
        add(btnAdd, BorderLayout.SOUTH);
    }

    private void refreshProgramList(){
        programModel.clear();
        for(Program program : ProgramManager.getInstance().getPrograms().values()){
            programModel.addElement(program);
        }
    }

    @Override
    public void update(String message) {
        refreshProgramList();
    }

    private void btnAddEvent(){
        btnAdd.addActionListener(e->{
            new ProgramDialog();
        });
    }
}
