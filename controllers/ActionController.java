package com.philobyte.instigate.controllers;

import com.philobyte.instigate.models.ActionModel;
import com.philobyte.instigate.views.ActionView;

/*
 * This is the controller for all actions taken by the player, a go between for the view and the model
*/

public class ActionController {
    private static ActionController instance;
    private ActionModel model;
    private ActionView view;

    public ActionController(ActionModel aModel, ActionView aView){
        instance = this;
        this.model = aModel;
        this.view = aView;
    }

    public ActionView getView(){
        return this.view;
    }

    public static ActionController getInstance(){
        return instance;
    }

    public ActionModel getModel(){
        return this.model;
    }
}