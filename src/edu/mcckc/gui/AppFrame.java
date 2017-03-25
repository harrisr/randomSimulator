package edu.mcckc.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rharris on 3/25/2017.
 */
public class AppFrame extends JFrame
{
    private AppPanel pnlApp;
    private DisplayPanel pnlDisplay;

    public AppFrame()
    {
        pnlApp = new AppPanel();
        pnlDisplay = new DisplayPanel();

        add(pnlApp, BorderLayout.NORTH);
        add(pnlDisplay, BorderLayout.CENTER);

        pnlDisplay.setAppPanelReference(pnlApp);
        pnlApp.setDisplayPanelReference(pnlDisplay);
    }
}
