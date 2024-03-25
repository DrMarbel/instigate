package com.philobyte.instigate.views;

import javax.swing.*;
import java.awt.*;

public class EventView extends JPanel{
    private static EventView instance;
    private JTextArea textArea;

    // A view to style and display synchronous event messages
    public EventView(){
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(300, 400));
        setLayout(new BorderLayout());
        this.textArea = new JTextArea();
        this.textArea.setWrapStyleWord(true);
        this.textArea.setLineWrap(true);
        JLabel eventLabel = new JLabel("Event Pane");
        eventLabel.setForeground(Color.WHITE);
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        add(eventLabel, BorderLayout.NORTH);
        add(this.textArea, BorderLayout.CENTER);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.textArea.setEditable(false);
        instance = this;
    }

    public JTextArea getTextArea(){
        return this.textArea;
    }
}