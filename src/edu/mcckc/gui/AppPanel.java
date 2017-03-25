package edu.mcckc.gui;

import edu.mcckc.domain.RandomSimulator;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rharris on 3/25/2017.
 */
public class AppPanel extends JPanel implements ActionListener
{
    RandomSimulator simulator;
    private JLabel lblRunCount;
    private JLabel lblNumberCap;
    private JTextField txtRunCount;
    private JTextField txtNumberCap;
    private JButton btnSubmit;
    private JComboBox cboChooser;
    private String outputMessage;
    private DisplayPanel pnlDisplay;

    public AppPanel()
    {
        Logger.getLogger(AppPanel.class.getName()).debug("INSIDE APP PANEL setAppPanelReference");

        simulator = new RandomSimulator();
        lblRunCount = new JLabel("Run Count:");
        lblNumberCap = new JLabel("Random Number Cap:");
        txtRunCount = new JTextField("100", 7);
        txtNumberCap = new JTextField("6", 7);
        cboChooser = new JComboBox(RandomSimulator.RandomChooser.values());
        btnSubmit = new JButton("Run Simulation");
        outputMessage = "";

        add(lblRunCount);
        add(txtRunCount);
        add(lblNumberCap);
        add(txtNumberCap);
        add(cboChooser);
        add(btnSubmit);

        btnSubmit.addActionListener(this);

    }

    public void setDisplayPanelReference(DisplayPanel inputPanel)
    {
        Logger.getLogger(AppPanel.class.getName()).debug("INSIDE APP PANEL setDisplayPanelReference");
        pnlDisplay = inputPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        outputMessage = "";
        //repaint();
        try
        {
            RandomSimulator.RandomChooser choice = (RandomSimulator.RandomChooser)cboChooser.getSelectedItem();
            Logger.getLogger(AppPanel.class.getName()).debug(String.format("USER CHOSE: %s", choice));
            simulator.doSimulation(Integer.parseInt(txtRunCount.getText()), Integer.parseInt(txtNumberCap.getText()), choice);
            //simulator.displayResults();
            pnlDisplay.displayResults(simulator.getNumberArray());
        }
        catch (Exception ex)
        {
            Logger.getLogger(AppPanel.class.getName()).debug(ex.toString());
            outputMessage = "Please enter valid input";
            System.out.println(outputMessage);
            //repaint();
        }
    }
}
