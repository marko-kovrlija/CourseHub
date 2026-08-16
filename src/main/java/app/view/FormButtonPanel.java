package app.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class FormButtonPanel extends JPanel{

    private JButton btnCancel;
    private JButton btnCreate;

    public FormButtonPanel() {
        btnCancel = new JButton("Cancel");
        btnCreate = new JButton("Create");
        setLayout(new FlowLayout());
        add(btnCancel);
        add(btnCreate);
    }
}
