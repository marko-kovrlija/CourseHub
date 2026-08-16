package app;

import app.controller.ProgramController;
import app.view.MainFrame;
import app.view.ProgramPanel;

public class App {
    static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();

        ProgramPanel programPanel = new ProgramPanel();

        ProgramController programController = new ProgramController(mainFrame.getProgramPanel());
    }
}
