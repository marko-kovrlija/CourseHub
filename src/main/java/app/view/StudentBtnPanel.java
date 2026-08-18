package app.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class StudentBtnPanel extends JPanel {

    private JButton btnCancel;
    private JButton btnCreate;

    public StudentBtnPanel() {
        btnCancel = new JButton("Cancel");
        btnCreate = new JButton("Create");
        setLayout(new FlowLayout());
        add(btnCreate);
        add(btnCancel);
    }
}
