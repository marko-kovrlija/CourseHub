package app.controller;

import app.factory.ProgramFactory;
import app.manager.ProgramManager;
import app.model.*;
import app.view.ProgramDialog;
import app.view.ProgramPanel;

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
                String pName = programDialog.getFormPanel().getTxtName().getText();
                ProgramCategory programCategory = (ProgramCategory) programDialog.getFormPanel().getCbmProgramCategory().getSelectedItem();
                int maxStudents = Integer.parseInt(programDialog.getFormPanel().getTxtMaxStudents().getText());
                int price = Integer.parseInt(programDialog.getFormPanel().getTxtPrice().getText());

                if(programDialog.getFormPanel().getCbmProgramType().getSelectedItem() == ProgramType.COURSE){
                    CourseType courseType = (CourseType) programDialog.getFormPanel().getCbmCourseType().getSelectedItem();
                    int amountOfClasses = Integer.parseInt(programDialog.getFormPanel().getTxtClasses().getText());

                    Course c = ProgramFactory.createProgram(pName, programCategory, maxStudents, price, amountOfClasses, courseType);
                    ProgramManager.getInstance().addProgram(c);

                } else if (programDialog.getFormPanel().getCbmProgramType().getSelectedItem() == ProgramType.BOOTCAMP) {
                    int durationInWeeks = Integer.parseInt(programDialog.getFormPanel().getTxtDuration().getText());

                    Bootcamp b = ProgramFactory.createProgram(pName, programCategory, maxStudents, price, durationInWeeks);
                    ProgramManager.getInstance().addProgram(b);
                }

            });

            programDialog.setVisible(true);
        });
    }
}
