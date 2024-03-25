/*
 * Developer: Martin P. Belt
 * Project: Instigate
 * Project Start Timestamp: Monday, November 6, 2023, 6:01:05 PM
*/

package com.philobyte.instigate;

import com.philobyte.instigate.controllers.*;
import com.philobyte.instigate.models.*;
import com.philobyte.instigate.views.*;

public class Instigate {
    static EventController eControl;
    static StatusController sControl;
    static ActionController aControl;
    static WindowController wControl;
    static PlayerModel player;
    static EnemyModel enemy;

    public static void main(String[] args){

        // Initialize essential components
        eControl = initializeEvent();
        enemy = initializeEnemy();
        sControl = initializeStatus();
        aControl = initializeAction();
        wControl = initializeWindow();
        player = initializePlayer();

        wControl.collectControllers(eControl, sControl, aControl);

        // DEBUG CONTROLLERS
        // System.out.println(EventController.getInstance());
        // System.out.println(StatusController.getInstance());
        // System.out.println(ActionController.getInstance());
        // System.out.println(WindowController.getInstance());

        MansionModel mansion = new MansionModel();

        System.out.println(PlayerController.getController().getPlayerLocationName());

        for (MansionRoom room : PlayerController.getController().getPlayerLocation().getAdjacentRooms()) {
            System.out.println(room.getRoomName());
        }

        System.out.println(EnemyController.getController().getEnemyLocation().getFloor());
        EnemyController.getController().startEnemyMovement();
    }

    // Initialization methods for essential MVC//MC/CV components
    public static EventController initializeEvent(){
        EventModel eModel = new EventModel();
        EventView eView = new EventView();
        eControl = new EventController(eModel, eView);

        return eControl;
    }
    public static StatusController initializeStatus(){
        StatusModel sModel = new StatusModel();
        StatusView sView = new StatusView();
        sControl = new StatusController(sModel, sView);

        return sControl;
    }
    public static ActionController initializeAction(){
        ActionView aView = new ActionView();
        ActionModel aModel = new ActionModel();
        aControl = new ActionController(aModel, aView);

        return aControl;
    }
    public static WindowController initializeWindow(){
        WindowModel wModel = new WindowModel();
        WindowView wView = new WindowView();
        wControl = new WindowController(wModel, wView);
        wControl.getView().addViews();

        return wControl;
    }
    public static PlayerModel initializePlayer(){
        return new PlayerModel();
    }
    public static EnemyModel initializeEnemy(){
        return new EnemyModel();
    }
}