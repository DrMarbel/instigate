package com.philobyte.instigate.views;

import javax.swing.*;

import com.philobyte.instigate.controllers.StatusController;

import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

// The Status Window MVC set's view: this tells the player everything they need to know about the enemy and it's whereabouts

public class StatusView extends JPanel{
    private static StatusView instance;
    private JTextArea textArea;
    Timer timer;
    
    public StatusView(){
        instance = this;
        setBackground(Color.BLACK);
        setSize(new Dimension(300, 100));
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        JLabel statusLabel = new JLabel("Status Pane");
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(statusLabel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        textArea.setEditable(false);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateStatus(StatusController.getInstance().getModel().getMessage());
            }
        }, 0, 5000);
    }

    // Constantly updates the status window to include any & all new messages generated
    public void updateStatus(String message) {
        SwingUtilities.invokeLater(() -> {
            textArea.append(message + "\n");
            textArea.setCaretPosition(textArea.getDocument().getLength());
        });
    }
}