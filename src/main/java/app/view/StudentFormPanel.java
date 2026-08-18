package app.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class StudentFormPanel extends JPanel {

    private JLabel lblName;
    private JTextField txtName;

    private JLabel lblSurname;
    private JTextField txtSurname;

    private JLabel lblEmail;
    private JTextField txtEmail;

    public StudentFormPanel() {
        setLayout(new GridLayout(0, 2, 10, 10));
        initElements();
        addElements();
    }

    private void initElements(){
        lblName = new JLabel("Name:");
        txtName = new JTextField();

        lblSurname = new JLabel("Surname:");
        txtSurname = new JTextField();

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
    }

    private void addElements(){
        add(lblName);
        add(txtName);
        add(lblSurname);
        add(txtSurname);
        add(lblEmail);
        add(txtEmail);
    }

    public String getName(){
        return txtName.getText();
    }

    public String getSurname(){
        return txtSurname.getText();
    }

    public String getEmail(){
        return txtEmail.getText();
    }

}
