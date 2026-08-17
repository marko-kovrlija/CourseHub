package app.view;

import app.manager.ProgramManager;
import app.model.Student;
import app.observer.ProgramObserver;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class StudentPanel extends JPanel implements ProgramObserver {

    private DefaultListModel<Student> studentModel;
    private JList<Student> studentsList;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnEdit;

    public StudentPanel() {
        setLayout(new BorderLayout());
        initElements();
        addElements();

        refreshStudentList();
        ProgramManager.getInstance().addObserver(this);
    }

    private void initElements(){
       studentModel = new DefaultListModel<>();
       studentsList = new JList<>(studentModel);
       btnAdd = new JButton("Add");
       btnRemove = new JButton("Remove");
       btnEdit = new JButton("Edit");
    }

    private void addElements(){
        JScrollPane scrollPane = new JScrollPane(studentsList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(btnAdd);
        btnPanel.add(btnRemove);
        btnPanel.add(btnEdit);
        add(btnPanel, BorderLayout.SOUTH);
    }

    private void refreshStudentList(){
        studentModel.clear();
        for(Student s : ProgramManager.getInstance().getStudents().values()){
            studentModel.addElement(s);
        }
    }

    @Override
    public void update(String message) {
        refreshStudentList();
    }
}
