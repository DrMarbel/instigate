package com.philobyte.instigate.controllers;

import java.util.Timer;
import java.util.TimerTask;

import com.philobyte.instigate.models.EnemyModel;
import com.philobyte.instigate.models.MansionRoom;
import com.philobyte.instigate.views.StatusView;

/*
 * This is the controller for all actions taken by the enemy, a go between for the view and the model
*/

public class EnemyController {
    private static EnemyController instance;
    private EnemyModel eInstance;

    public EnemyController(EnemyModel enemy) {
        instance = this;
        this.eInstance = enemy;
    }

    // A method that starts a timer to check against certain time-based aspects of enemy states
    public void enemyMovement(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                switch (eInstance.getState()) {
                    case IDLE:
                        break;
                    case HUNTING:
                        eInstance.huntPlayer();
                        break;
                    default:
                        break;
                }
            }
        }, 0, 10000);
    }

    // A method that calls another method to begin the asyncronous movement of the enemy
    public void startEnemyMovement(){
        enemyMovement();
    }

    public static EnemyController getController() {
        return instance;
    }

    public EnemyModel getEnemy() {
        return this.eInstance;
    }

    public MansionRoom getEnemyLocation() {
        return this.eInstance.getLocation();
    }

    public String getEnemyLocationName() {
        return this.eInstance.getLocationName();
    }

    public void setEnemyLocation(MansionRoom room) {
        this.eInstance.setLocation(room);
    }
}