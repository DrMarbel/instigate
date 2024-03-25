package com.philobyte.instigate.controllers;

import com.philobyte.instigate.models.StatusModel;
import com.philobyte.instigate.views.StatusView;

/*
 * This MVC set is special to this game, a primary feature
 * An asyncronous window that doesn't stop at the whims of the player
 * This is the controller for the Status Window
*/

public class StatusController {
    private static StatusController instance;
    private StatusModel model;
    private StatusView view;

    public StatusController(StatusModel sModel, StatusView sView){
        instance = this;
        this.model = sModel;
        this.view = sView;
    }

    public StatusView getView(){
        return this.view;
    }

    public static StatusController getInstance(){
        return instance;
    }

    public StatusModel getModel(){
        return this.model;
    }
}