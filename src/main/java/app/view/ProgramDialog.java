package app.view;

import javax.swing.*;
import java.awt.*;

public class ProgramDialog extends JDialog {

    private FormPanel formPanel;
    private FormButtonPanel formButtonPanel;

    public ProgramDialog() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/3 , getDim(toolkit));
        setTitle("Add program");
        setLocationRelativeTo(null);
        setModal(true);
        createPanels();

        add(formPanel, BorderLayout.CENTER);
        add(formButtonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    void createPanels(){
        formPanel = new FormPanel();
        formButtonPanel = new FormButtonPanel();
    }

    private int getDim(Toolkit toolkit){
        double d = toolkit.getScreenSize().getHeight()*0.37;
        return (int) d;
    }
}
