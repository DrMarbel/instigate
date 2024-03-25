package com.philobyte.instigate.views;

import javax.swing.*;

import com.philobyte.instigate.controllers.ActionController;
import com.philobyte.instigate.controllers.EventController;
import com.philobyte.instigate.controllers.StatusController;
import com.philobyte.instigate.controllers.WindowController;

import java.awt.*;

// This literally just create the program window to hold the various views and UI elements in the game

public class WindowView extends JFrame{
    private static WindowView instance;
    private JPanel display;
    private GridBagConstraints egbc;
    private GridBagConstraints sgbc;
    private GridBagConstraints agbc;

    public WindowView(){
        super("Game");
        instance = this;

        display = new JPanel(new GridBagLayout());

        display.setBackground(Color.BLACK);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addViews() {
        // Event View
        this.egbc = new GridBagConstraints();
        this.egbc.fill = GridBagConstraints.BOTH;
        this.egbc.weightx = 1.0;
        this.egbc.weighty = 1.0;
        this.egbc.gridx = 0;
        this.egbc.gridy = 0;
        this.egbc.gridwidth = 1;
        this.egbc.gridheight = 2;
        this.egbc.insets = new Insets(10, 10, 10, 10);
        display.add(EventController.getInstance().getView(), this.egbc);
    
        // Status View
        this.sgbc = new GridBagConstraints();
        this.sgbc.fill = GridBagConstraints.BOTH;
        this.sgbc.weightx = 1.0;
        this.sgbc.weighty = 0.5;
        this.sgbc.gridx = 1;
        this.sgbc.gridy = 0;
        this.sgbc.gridwidth = 1;
        this.sgbc.gridheight = 1;
        this.sgbc.insets = new Insets(10, 10, 10, 10);
        display.add(StatusController.getInstance().getView(), this.sgbc);
    
        // Action View
        this.agbc = new GridBagConstraints();
        this.agbc.fill = GridBagConstraints.BOTH;
        this.agbc.weightx = 1.0;
        this.agbc.weighty = 0.5;
        this.agbc.gridx = 1;
        this.agbc.gridy = 1;
        this.agbc.gridwidth = 1;
        this.agbc.gridheight = 1;
        this.agbc.insets = new Insets(10, 10, 10, 10);
        display.add(ActionController.getInstance().getView(), this.agbc);
    
        instance.add(display);
        instance.setVisible(true);
    }
}