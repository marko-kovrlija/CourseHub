package app.controller;

import app.factory.ProgramFactory;
import app.manager.ProgramManager;
import app.model.*;
import app.view.FormPanel;
import app.view.ProgramDialog;
import app.view.ProgramPanel;

import javax.swing.*;

public class ProgramController {

    private ProgramPanel programPanel;

    public ProgramController(ProgramPanel programPanel) {
        this.programPanel = programPanel;
        setupListeners();
    }

    private void setupListeners(){
        programPanel.getBtnAdd().addActionListener(e->{
            ProgramDialog programDialog = new ProgramDialog();

            programDialog.getFormButtonPanel().getBtnCancel().addActionListener(cancelEvent->{
                programDialog.dispose();
            });

            programDialog.getFormButtonPanel().getBtnCreate().addActionListener(createEvent->{

                try{
                    FormPanel form = programDialog.getFormPanel();

                    String pName = form.getName();
                    ProgramCategory programCategory = form.getCategory();
                    int maxStudents = form.getMaxStudents();
                    int price = form.getPrice();

                    if(form.getProgramType() == ProgramType.COURSE){
                        CourseType courseType = form.getCourseType();
                        int amountOfClasses = form.getAmountOfClasses();

                        Course c = ProgramFactory.createProgram(pName, programCategory, maxStudents, price, amountOfClasses, courseType);
                        ProgramManager.getInstance().addProgram(c);

                    } else if (form.getProgramType() == ProgramType.BOOTCAMP) {
                        int durationInWeeks = form.getDurationInWeeks();

                        Bootcamp b = ProgramFactory.createProgram(pName, programCategory, maxStudents, price, durationInWeeks);
                        ProgramManager.getInstance().addProgram(b);
                    }

                    programDialog.dispose();

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(
                            programDialog,
                            "Please enter valid numbers.",
                            "Invalid input",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            programDialog,
                            ex.getMessage(),
                            "Invalid program",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            programDialog.setVisible(true);
        });

        programPanel.getBtnRemove().addActionListener(e->{
            Program p = programPanel.getProgramList().getSelectedValue();
            if(p != null){
                ProgramManager.getInstance().removeProgram(p);
            }
            else{
                JOptionPane.showMessageDialog(programPanel, "Select a program from a list!");
            }
        });
    }
}
