package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private String direction;
    private Room goNorth;
    private Room goWest;
    private Room goEast;
    private Room goSouth;
    private Room currentRoom;
    private List<Item> items = new ArrayList();

    public void takeItem( Item item){
        items.add(item);
        item.setPlayer(this);
        item.setRoom(null);
    }

    public void dropItem(Item item, Room room) {
        items.add(item);
        item.setPlayer(null);
        item.setRoom(room);
    }
    public List<Item> getItem(){
        return items;
    }
     public void setItem(List<Item> items){
        this.items = items;
     }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void getHeading() {

    }

    public Room getGoNorth() {
        if (currentRoom.getGoNorth() != null) {
            currentRoom = currentRoom.getGoNorth();
            return currentRoom;
        } else {
            System.out.println("You can not go this way");
        }
        return null;
    }

    public Room getGoWest() {
        if (currentRoom.getGoWest() != null) {
           currentRoom = currentRoom.getGoWest();
           return currentRoom;
        } else {
            System.out.println("You can not go this way");
        }
        return null;
    }

    public Room getGoEast() {
        if (currentRoom.getGoEast() != null) {
             currentRoom = currentRoom.getGoEast();
             return currentRoom;
        } else {
            System.out.println("You can not go this way");
        }
        return null;
    }

    public Room getGoSouth() {
        if (currentRoom.getGoSouth() != null) {
            currentRoom = currentRoom.getGoSouth();
            return currentRoom;
        } else {
            System.out.println("You can not go this way");
        }
        return null;
    }
}
