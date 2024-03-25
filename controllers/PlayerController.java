package com.philobyte.instigate.controllers;

import com.philobyte.instigate.models.MansionRoom;
import com.philobyte.instigate.models.PlayerModel;

// A controller for the player to act as a go between for the player model

public class PlayerController {
    private static PlayerController instance;
    private PlayerModel pInstance;

    public PlayerController(PlayerModel player){
        instance = this;
        this.pInstance = player;
    }

    public static PlayerController getController(){
        return instance;
    }

    public PlayerModel getPlayer(){
        return this.pInstance;
    }

    public MansionRoom getPlayerLocation(){
        MansionRoom room = this.pInstance.getLocation();
        return room;
    }

    public String getPlayerLocationName(){
        String location = this.pInstance.getLocationName();
        return location;
    }

    // A method used by the 'Hide' button and related actions for the player to hide
    public void toggleVisibility() {
        this.pInstance.setVisibility(!this.pInstance.getVisibility());
    }

    public void setPlayerLocation(MansionRoom room) {
        this.pInstance.setLocation(room);
    }
}