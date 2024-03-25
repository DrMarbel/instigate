package com.philobyte.instigate.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.philobyte.instigate.controllers.ActionController;

public class ActionView extends JPanel {
    private static ActionView instance;
    private JTextField commandField;

    // This create the view that holds the buttons and UI elements necessary for the player to interact with the world
    public ActionView() {
        setBackground(Color.BLACK);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel actionsLabel = new JLabel("Actions Pane");
        actionsLabel.setForeground(Color.WHITE);
        actionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(actionsLabel);

        commandField = new JTextField(20);
        commandField.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(commandField);

        JButton button1 = new JButton("Map");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MapController.showMapDialog();
                System.out.println("Map Displaying");
            }
        });
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Move button
        JButton button2 = new JButton("Move");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = commandField.getText();
                System.out.println("User input: " + userInput);
                ActionController.getInstance().getModel().moveTo(userInput);
            }
        });
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Hide button
        JButton button3 = new JButton("Hide");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionController.getInstance().getModel().hideEvent();
            }
        });
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(button1);
        add(button2);
        add(button3);
        instance = this;
    }
}