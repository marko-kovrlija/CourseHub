package app.view;

import app.model.CourseType;
import app.model.ProgramCategory;
import app.model.ProgramType;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class FormPanel extends JPanel {


    private JLabel lblProgramType;
    private JComboBox<ProgramType> cbmProgramType;

    private JLabel lblName;
    private JTextField txtName;

    private JLabel lblCategory;
    private JComboBox<ProgramCategory> cbmProgramCategory;

    private JLabel lblMaxStudents;
    private JTextField txtMaxStudents;

    private JLabel lblPrice;
    private JTextField txtPrice;

    private JLabel lblCourseType;
    private JComboBox<CourseType> cbmCourseType;

    private JLabel lblAmountOfClasses;
    private JTextField txtClasses;

    private JLabel lblDuration;
    private JTextField txtDuration;

    private JPanel specificPanel;
    private CardLayout cardLayout;

    public FormPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        createCommonFields();
        createSpecificFields();

        selectSpecificPanel();

        add(createCommonPanel(), BorderLayout.CENTER);
        add(specificPanel, BorderLayout.SOUTH);
    }

    private void createCommonFields() {
        lblProgramType = new JLabel("Program type:");
        cbmProgramType = new JComboBox<>(ProgramType.values());

        lblName = new JLabel("Program name:");
        txtName = new JTextField();

        lblCategory = new JLabel("Category:");
        cbmProgramCategory = new JComboBox<>(ProgramCategory.values());

        lblMaxStudents = new JLabel("Max students:");
        txtMaxStudents = new JTextField();

        lblPrice = new JLabel("Price:");
        txtPrice = new JTextField();
    }

    private JPanel createCommonPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        panel.add(lblProgramType);
        panel.add(cbmProgramType);

        panel.add(lblName);
        panel.add(txtName);

        panel.add(lblCategory);
        panel.add(cbmProgramCategory);

        panel.add(lblMaxStudents);
        panel.add(txtMaxStudents);

        panel.add(lblPrice);
        panel.add(txtPrice);

        return panel;
    }

    private void createSpecificFields() {

        // Course
        lblCourseType = new JLabel("Course type:");
        cbmCourseType = new JComboBox<>(CourseType.values());

        lblAmountOfClasses = new JLabel("Amount of classes:");
        txtClasses = new JTextField();

        JPanel coursePanel = new JPanel(new GridLayout(0, 2, 10, 10));

        coursePanel.add(lblCourseType);
        coursePanel.add(cbmCourseType);

        coursePanel.add(lblAmountOfClasses);
        coursePanel.add(txtClasses);


        // Bootcamp
        lblDuration = new JLabel("Duration (weeks):");
        txtDuration = new JTextField();

        JPanel bootcampPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        bootcampPanel.add(lblDuration);
        bootcampPanel.add(txtDuration);


        // CardLayout
        cardLayout = new CardLayout();
        specificPanel = new JPanel(cardLayout);

        specificPanel.add(coursePanel, "COURSE");
        specificPanel.add(bootcampPanel, "BOOTCAMP");

        cardLayout.show(specificPanel, "COURSE");
    }

    private void selectSpecificPanel(){
        cbmProgramType.addActionListener(e -> {
            ProgramType selectedType = (ProgramType) cbmProgramType.getSelectedItem();

            if (selectedType == ProgramType.COURSE) {
                cardLayout.show(specificPanel, "COURSE");
            } else if (selectedType == ProgramType.BOOTCAMP) {
                cardLayout.show(specificPanel, "BOOTCAMP");
            }
        });
    }

    public ProgramType getProgramType(){
        return (ProgramType) cbmProgramType.getSelectedItem();
    }

    public String getName(){
        return txtName.getText();
    }

    public ProgramCategory getCategory(){
        return (ProgramCategory) cbmProgramCategory.getSelectedItem();
    }

    public int getMaxStudents(){
        return Integer.parseInt(txtMaxStudents.getText());
    }

    public int getPrice(){
        return Integer.parseInt(txtPrice.getText());
    }

    public CourseType getCourseType(){
        return (CourseType) cbmCourseType.getSelectedItem();
    }

    public int getAmountOfClasses(){
        return Integer.parseInt(txtClasses.getText());
    }

    public int getDurationInWeeks(){
        return Integer.parseInt(txtDuration.getText());
    }
}