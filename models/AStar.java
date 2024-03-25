package com.philobyte.instigate.models;

import java.util.ArrayList;
import java.util.List;

/*
 * This is the A* algorithm, a pathfinding algorithm that is meant to be used by the enemy for it's 'HUNTING' state
 * (Untested)
*/

public class AStar {

    public static List<MansionRoom> findPath(MansionRoom start, MansionRoom goal) {
        // Create two lists, one for the projected path, and the other for the room that have already been visited
        List<MansionRoom> path = new ArrayList<>();
        List<MansionRoom> visited = new ArrayList<>();

        if (explore(start, goal, path, visited)) {
            // Path found
            return path;
        } else {
            // No path found
            return new ArrayList<>();
        }
    }

    private static boolean explore(MansionRoom current, MansionRoom goal, List<MansionRoom> path, List<MansionRoom> visited) {
        path.add(current);
        visited.add(current);

        // Is the enemy currently where the goal is?
        if (current == goal) {
            // Found a path
            return true;
        }

        // Slightly recursive method to allow for continued progression
        for (MansionRoom neighbor : current.getAdjacentRooms()) {
            if (!visited.contains(neighbor)) {
                if (explore(neighbor, goal, path, visited)) {
                    return true;
                }
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
        return false;
    }
}
