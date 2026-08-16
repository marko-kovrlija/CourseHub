package app.view;

import javax.swing.*;
import java.awt.*;

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
