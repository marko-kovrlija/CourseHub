package app.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainFrame extends JFrame {

    private ProgramPanel programPanel;
    private StudentPanel studentPanel;

    public MainFrame() {
        setTitle("CourseHub");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/2 , screenSize.height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        programPanel = new ProgramPanel();
        studentPanel = new StudentPanel();

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Programs", programPanel);
        tabbedPane.addTab("Students", studentPanel);

        add(tabbedPane);

        setVisible(true);
    }
}
