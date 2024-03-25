package com.philobyte.instigate.models;

import java.util.Random;

import com.philobyte.instigate.controllers.EnemyController;

// The Status Window MVC set's model

public class StatusModel {
    private static StatusModel instance;
    String msg;

    Random randRoom = new Random();
    Random randDirection = new Random();
    Random randSound = new Random();

    public StatusModel(){
        instance = this;
    }

    // This method passes the generated message to the view
    public String getMessage(){
        msg = generateEnemyMessage();
        return msg;
    }

    // This is meant to generate messages to tell the player where the enemy is at any given moment
    public String generateEnemyMessage() {
        String[] messages = {
            "You hear a noise coming from the " + EnemyController.getController().getEnemyLocationName() + ".",
            "The sound of footsteps echoes from the " + EnemyController.getController().getEnemyLocationName() + "."
        };

        int randomIndex = randSound.nextInt(messages.length);
        return messages[randomIndex];
    }
}