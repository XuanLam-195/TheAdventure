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
    private int health = 100;
    private Weapon weapon;


    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else {
            return false;
        }
    }

    private List<Item> inventory = new ArrayList();


    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    public int getHealth() {
        return health;
    }

    public void takeItem(Item item) {
        inventory.add(item);
        item.setPlayer(this);
        item.setRoom(null);
    }

    public void dropItem(Item item, Room room) {
        inventory.remove(item);
        item.setPlayer(null);
        item.setRoom(room);
    }

    public void eatFood(Food food, Room room) {
        health = health + food.getHealthBonus();
        room.getItems().remove(food);
    }

    public void eatFood(Food food) {
        health = health + food.getHealthBonus();
        inventory.remove(food);
    }


    public List<Item> getInventory() {
        return inventory;
    }

    public void setItem(List<Item> items) {
        this.inventory = items;
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

    public void setName(String name) {
        this.name = name;
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
