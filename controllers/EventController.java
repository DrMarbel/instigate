package com.philobyte.instigate.controllers;

import com.philobyte.instigate.models.EventModel;
import com.philobyte.instigate.views.EventView;

/*
 * This is the controller that acts as a go between for the event model and the event view
*/

public class EventController {
    private static EventController instance;
    private EventModel model;
    private EventView view;

    public EventController(EventModel eModel, EventView eView) {
        instance = this;
        this.model = eModel;
        this.view = eView;
    }

    public EventView getView(){
        return this.view;
    }

    public static EventController getInstance(){
        return instance;
    }
}