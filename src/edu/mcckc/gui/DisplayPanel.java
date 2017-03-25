package edu.mcckc.gui;

import edu.mcckc.driver.Main;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;

/**
 * Created by rharris on 3/25/2017.
 */
public class DisplayPanel extends JPanel
{
    private int[] randomNumbers;
    private AppPanel pnlApp;
    private Graphics g;

    public DisplayPanel()
    {
        Logger.getLogger(DisplayPanel.class.getName()).debug("INSIDE DISPLAY PANEL CONSTRUCTOR");
    }

    public void setAppPanelReference(AppPanel inputPanel)
    {
        Logger.getLogger(DisplayPanel.class.getName()).debug("INSIDE DISPLAY PANEL setAppPanelReference");
        pnlApp = inputPanel;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Logger.getLogger(DisplayPanel.class.getName()).debug("INSIDE DISPLAY PANEL +++++ PAINT +++++");
        this.g = g;
        displayRectangles();
    }

    private void displayRectangles()
    {
        Logger.getLogger(DisplayPanel.class.getName()).debug("INSIDE DISPLAY PANEL ++ DISPLAY RECTANGLES++");
        System.out.println();
        if (g != null && randomNumbers != null)
        {
            for (int i=0; i<randomNumbers.length; i++)
            {
                Logger.getLogger(DisplayPanel.class.getName()).debug(String.format("--->  %d: %d", i, randomNumbers[i]));
                g.fillRect((i+1)*20, 20, 10, randomNumbers[i]);
            }
        }
    }

    public void displayResults(int[] inputArray)
    {
        Logger.getLogger(DisplayPanel.class.getName()).debug("INSIDE DISPLAY PANEL DISPLAY_RESULTS");
        this.randomNumbers = inputArray;
        displayRectangles();
        repaint();
    }
}
