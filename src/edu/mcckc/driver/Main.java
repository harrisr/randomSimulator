package edu.mcckc.driver;

import edu.mcckc.domain.RandomSimulator;
import edu.mcckc.gui.AppFrame;
import org.apache.log4j.Logger;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        Logger.getLogger(Main.class.getName()).debug("BEGINNING THE PROGRAM");

        AppFrame frmApp = new AppFrame();
        frmApp.setTitle("Random Number Simulation");
        frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmApp.setSize(700,400);
        frmApp.setVisible(true);

        Logger.getLogger(Main.class.getName()).debug("ENDING THE PROGRAM");
    }
}
