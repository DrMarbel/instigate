package com.philobyte.instigate.models;

import java.util.ArrayList;
import java.util.List;

// The blueprints for a mansion room
public class MansionRoom {
    private String roomName;
    private List<MansionRoom> adjacentRooms;
    private boolean hasStairwell = false;
    private String direction;
    private String roomDirection;
    private int floor;

    public MansionRoom(String roomName) {
        this.roomName = roomName;
        this.adjacentRooms = new ArrayList<>();
    }

    // Add a pathway between rooms
    public void addAdjacentRoom(MansionRoom room) {
        adjacentRooms.add(room);
    }

    // Export a list of other rooms able to be accessed from current point
    public List<MansionRoom> getAdjacentRooms() {
        return this.adjacentRooms;
    }

    // What's the room name?
    public String getRoomName() {
        return this.roomName;
    }

    public boolean isAdjacentTo(MansionRoom otherRoom) {
        return adjacentRooms.contains(otherRoom);
    }

    // This enables the vertical movement of the player by signaling an upward pathway
    public void enableStairs(String direction){
        this.hasStairwell = true;
        this.direction = direction;
    }

    // Floor number
    public void setFloor(int floor){
        this.floor = floor;
    }

    // Export floor number
    public String getFloor(){
        String floorString;
        if(this.floor < 0){
            floorString = "B" + (this.floor * this.floor);
        } else {
            floorString = String.format("%d", this.floor);
        }

        return floorString;
    }
}