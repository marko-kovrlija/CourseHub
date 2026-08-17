package app.view;

import app.manager.ProgramManager;
import app.model.Program;
import app.observer.ProgramObserver;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class ProgramPanel extends JPanel implements ProgramObserver {

    private DefaultListModel<Program> programModel;
    private JList<Program> programList;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnEdit;
    private JButton btnDetails;

    public ProgramPanel() {
        setLayout(new BorderLayout());

        initElements();
        addElements();

        refreshProgramList();

        ProgramManager.getInstance().addObserver(this);
    }

    private void initElements() {
        programModel = new DefaultListModel<>();
        programList = new JList<>(programModel);
        btnAdd = new JButton("Add program");
        btnRemove = new JButton("Remove");
        btnEdit = new JButton("Edit");
        btnDetails = new JButton("Details");
    }

    private void addElements(){
        JScrollPane scrollPane = new JScrollPane(programList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(btnAdd);
        btnPanel.add(btnRemove);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDetails);

        add(btnPanel, BorderLayout.SOUTH);
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
}
