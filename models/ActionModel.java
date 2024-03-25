package com.philobyte.instigate.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.philobyte.instigate.controllers.*;

/*
 * This is the action model, which contains all actions able to be taken by the player
*/

public class ActionModel {
    private static ActionModel instance;
    private JTextArea text;

    public ActionModel() { 
        instance = this;
    }

    // A toggler method that allows the player to hide from the enemy
    public void hideEvent() {
        if (PlayerController.getController().getPlayer().getVisibility() == false) {
            PlayerController.getController().toggleVisibility();
            SwingUtilities.invokeLater(() -> {
                text = EventController.getInstance().getView().getTextArea();
                text.append("You are hidden.\n");
                text.setCaretPosition(text.getDocument().getLength());
            });
        } else {
            PlayerController.getController().toggleVisibility();
            SwingUtilities.invokeLater(() -> {
                text = EventController.getInstance().getView().getTextArea();
                text.append("You are no longer hidden.\n");
                text.setCaretPosition(text.getDocument().getLength());
            });
        }
    }

    // This method appends event messages to the event pane
    public void appendToEventView(String msg){
        SwingUtilities.invokeLater(() -> {
            text = EventController.getInstance().getView().getTextArea();
            text.append(msg);
            text.setCaretPosition(text.getDocument().getLength());
        });
    }

    // This method dictates available player movements based on rooms adjacent to one another
    public void moveTo(String command) {
        if(isValid(command)){
            System.out.println(command + " is a valid room.");
            if (adjacentTo(command)) {
                MansionRoom newRoom = getRoom(command);
                PlayerController.getController().setPlayerLocation(newRoom);
                appendToEventView("You have moved to the " + newRoom.getRoomName() + ".\n");
            } else {
                appendToEventView("You cannot go to the " + command + " from here.\n");
            }
        } else {
            System.out.println(command + " is not a valid room.");
            appendToEventView("Impossible. No such room exists, plebian.\n");
        }
    }

    // This method checks a hard-coded list to see if one room is next to another and if a path between them exists, and returns a boolean value
    private boolean adjacentTo(String command) {
        List<MansionRoom> rooms = PlayerController.getController().getPlayerLocation().getAdjacentRooms();
        boolean value = false;

        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i).getRoomName().equals(command) && PlayerController.getController().getPlayerLocation().isAdjacentTo(rooms.get(i))){
                value = true;
            } else {
                value = value;
            }
        }

        return value;
    }

    // A method to obtain the list of rooms from a Mansion Model method for use in player movement
    private MansionRoom getRoom(String command) {
        List<MansionRoom> rooms = MansionModel.getAllRooms();
        MansionRoom room = null;

        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getRoomName().equals(command)){
                room = rooms.get(i);
            }
        }

        return room;
    }

    // A method to check and see if a room exists in the list of rooms available
    private boolean isValid(String command) {
        List<MansionRoom> rooms = MansionModel.getAllRooms();

        for (MansionRoom mansionRoom : rooms) {
            System.out.println(mansionRoom.getRoomName());
        }
    
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomName().equals(command)) {
                return true;
            }
        }
    
        return false;
    }    
}