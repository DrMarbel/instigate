package com.philobyte.instigate.models;

import java.util.List;
import java.util.Random;

import com.philobyte.instigate.controllers.EnemyController;
import com.philobyte.instigate.controllers.PlayerController;
import com.philobyte.instigate.controllers.StatusController;

/*
 * This is the enemy model, which contains all actions able to be taken by the enemy
*/

public class EnemyModel {
    private static EnemyModel instance;
    private String name;
    private MansionRoom initialLocation = MansionModel.servantsHall;
    private MansionRoom location;
    private EnemyController controller;
    private EnemyState state = EnemyState.HUNTING;

    // Constructor to build the enemy
    public EnemyModel() {
        instance = this;
        this.name = "Enemy";
        this.location = initialLocation;
        this.controller = new EnemyController(instance);
        this.state = EnemyState.HUNTING;
    }

    public MansionRoom getLocation() {
        return this.location;
    }

    public String getLocationName() {
        return this.location.getRoomName();
    }

    public void setLocation(MansionRoom room) {
        this.location = room;
    }

    public EnemyState getState(){
        return this.state;
    }

    // An ActorState method to provide instructions and messages for the enemy's IDLE state
    public void idle(){
        StatusController.getInstance().getView().updateStatus(this.name + " seems to be idling.");
    }

    // An ActorState method to provide instructions and messages for the enemy's HUNTING state
    public void huntPlayer() {
        List<MansionRoom> path = AStar.findPath(this.location, PlayerController.getController().getPlayerLocation());
        if (!path.isEmpty()) {
            MansionRoom newLocation = path.get(1); // Use the next room in the path
            setLocation(newLocation);
            StatusController.getInstance().getView().updateStatus("The enemy is hunting and has moved to the " + newLocation.getRoomName() + ".");
        }
    }

    // A method to enable a low-level pathfinding function, allowing the enemy to actually move from room to room
    public void moveEnemyRandomly() {
        List<MansionRoom> adjacentRooms = this.location.getAdjacentRooms();

        if (!adjacentRooms.isEmpty()) {
            int randomIndex = new Random().nextInt(adjacentRooms.size());
            MansionRoom newRoom = adjacentRooms.get(randomIndex);
            this.setLocation(newRoom);
        }
    }
}