package com.philobyte.instigate.models;

import java.util.ArrayList;
import java.util.List;

// A model class to create a 2D mansion floor layout
public class MansionModel {
    static MansionRoom grandEntryHall = new MansionRoom("Grand Hall");
    static MansionRoom drawingRoom = new MansionRoom("Drawing Room");
    static MansionRoom library = new MansionRoom("Library");
    static MansionRoom morningRoom = new MansionRoom("Morning Room");
    static MansionRoom mainDiningHall = new MansionRoom("Main Dining Hall");
    static MansionRoom kitchen = new MansionRoom("Kitchens");
    static MansionRoom servantsHall = new MansionRoom("Servant's Hall");
    static List<MansionRoom> allRooms = addAllRooms();
    
    public MansionModel(){
        // Grand Entry Hall paths
        grandEntryHall.addAdjacentRoom(drawingRoom);
        grandEntryHall.addAdjacentRoom(library);
        grandEntryHall.addAdjacentRoom(mainDiningHall);
        grandEntryHall.enableStairs("Up");
        grandEntryHall.setFloor(1);

        // Drawing Room paths
        drawingRoom.addAdjacentRoom(grandEntryHall);
        drawingRoom.addAdjacentRoom(morningRoom);
        drawingRoom.setFloor(1);

        // Library paths
        library.addAdjacentRoom(grandEntryHall);
        library.setFloor(1);

        // Main Dining Hall paths
        mainDiningHall.addAdjacentRoom(grandEntryHall);
        mainDiningHall.addAdjacentRoom(kitchen);
        mainDiningHall.setFloor(1);

        // Morning Room Paths
        morningRoom.addAdjacentRoom(drawingRoom);
        morningRoom.setFloor(1);

        // Kitchen paths
        kitchen.addAdjacentRoom(mainDiningHall);
        kitchen.addAdjacentRoom(servantsHall);
        kitchen.enableStairs("Down");
        kitchen.setFloor(1);

        // Servant's Hall
        servantsHall.addAdjacentRoom(kitchen);
        servantsHall.enableStairs("Up");
        servantsHall.setFloor(-1);
    }

    public static MansionRoom getRoot(){
        return grandEntryHall;
    }

    // Manually collect the rooms created and add them to an exportable list
    public static List<MansionRoom> addAllRooms(){
        List<MansionRoom> thisAllRooms = new ArrayList<>();
        thisAllRooms.add(grandEntryHall);
        thisAllRooms.add(drawingRoom);
        thisAllRooms.add(library);
        thisAllRooms.add(morningRoom);
        thisAllRooms.add(mainDiningHall);
        thisAllRooms.add(kitchen);
        thisAllRooms.add(servantsHall);

        return thisAllRooms;
    }

    // A method that exports the list of all mansion rooms and, by proxy, their pathways
    public static List<MansionRoom> getAllRooms(){
        return allRooms;
    }
}