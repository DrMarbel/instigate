package com.philobyte.instigate.models;

import com.philobyte.instigate.controllers.PlayerController;

// A model for the player

public class PlayerModel {
    private static PlayerModel instance;
    private String name;
    private int HP;
    private MansionRoom initialLocation = MansionModel.getRoot();
    private MansionRoom location;
    private PlayerController controller;
    private boolean hidden = false;

    public PlayerModel(){
        instance = this;
        this.name = "Gene";
        this.HP = 10;
        this.location = initialLocation;
        controller = new PlayerController(instance);
    }

    // Is the player hiding?
    public boolean getVisibility(){
        return this.hidden;
    }

    public MansionRoom getLocation(){
        return this.location;
    }

    public String getLocationName(){
        return this.location.getRoomName();
    }

    public void setVisibility(boolean toggle){
        this.hidden = toggle;
    }

    public void setLocation(MansionRoom room) {
        this.location = room;
    }
}