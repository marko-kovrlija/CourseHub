package app.view;

import javax.swing.*;
import java.awt.*;

public class ProgramDialog extends JDialog {

    public ProgramDialog() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/2 , screenSize.height/2);
        setTitle("Add program");
        setLocationRelativeTo(null);
        setModal(true);
        add(new FormPanel(), BorderLayout.CENTER);
        setVisible(true);
    }
}
