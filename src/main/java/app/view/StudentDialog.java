package app.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class StudentDialog extends JDialog {

    private StudentFormPanel studentFormPanel;
    private StudentBtnPanel studentBtnPanel;

    public StudentDialog() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/3 , getDim(toolkit));
        setTitle("Add student");
        setLocationRelativeTo(null);
        setModal(true);

        createPanels();
        add(studentFormPanel, BorderLayout.CENTER);
        add(studentBtnPanel, BorderLayout.SOUTH);
    }

    private void createPanels(){
        studentFormPanel = new StudentFormPanel();
        studentBtnPanel = new StudentBtnPanel();
    }

    private int getDim(Toolkit toolkit){
        double d = toolkit.getScreenSize().getHeight()*0.20;
        return (int) d;
    }
}
