package com.philobyte.instigate.controllers;

import com.philobyte.instigate.models.WindowModel;
import com.philobyte.instigate.views.WindowView;

// This is the controller to act as a go between for the window model and the window view

public class WindowController {
    private static WindowController instance;
    private WindowModel model;
    private WindowView view;
    private EventController eControl;
    private StatusController sControl;
    private ActionController aControl;

    public WindowController(WindowModel wModel, WindowView wView){
        instance = this;
        this.model = wModel;
        this.view = wView;
        this.eControl = EventController.getInstance();
        this.sControl = StatusController.getInstance();
        this.aControl = ActionController.getInstance();
    }

    public void collectControllers(EventController controllerE, StatusController controllerS, ActionController controllerA){
        this.eControl = controllerE;
        this.sControl = controllerS;
        this.aControl = controllerA;

        // DEBUG CONTROLLERS
        // System.out.println(eControl.getView());
        // System.out.println(sControl.getView());
        // System.out.println(aControl.getView());
    }

    public static WindowController getInstance(){
        return instance;
    }

    public WindowView getView(){
        return this.view;
    }
}