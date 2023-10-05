package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room goNorth;
    private Room goWest;
    private Room goEast;
    private Room goSouth;

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items){
        this.items = items;
    }

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public void setConnections(Room goNorth, Room goWest, Room goEast, Room goSouth) {
        this.goNorth = goNorth;
        this.goWest = goWest;
        this.goEast = goEast;
        this.goSouth = goSouth;
    }
    public String getRoomName() {
        return roomName;
    }
    public String getRoomDescription() {
        return roomDescription;
    }

    public Room getGoNorth() {
        return goNorth;
    }

    public void setGoNorth(Room goNorth) {
        this.goNorth = goNorth;
    }

    public void setGoWest(Room goWest) {
        this.goWest = goWest;
    }
    public void setGoEast(Room goEast) {
        this.goEast = goEast;
    }

    public void setGoSouth(Room goSouth) {
        this.goSouth = goSouth;
    }
    public Room getGoWest() {
        return goWest;
    }
    public Room getGoEast() {
        return goEast;
    }
    public Room getGoSouth() {
        return goSouth;
    }

    @Override
    public String toString() {
        return " " + roomName +
                ", " + roomDescription;
    }
}

