package org.example;

import java.util.List;

public class Adventure {
    private Player player;
    List<Player> players;
    List<Room> room;
    List<Item> items;


    public Adventure() {
        CreateMap createMap = new CreateMap();
        createMap.Create();
        this.player = new Player("John", 500, createMap.getRoom1());
    }

    public Item findAndPick(String name) {
        Item item = null;
        Room room = player.getCurrentRoom();
        for (Item itemInRoom : room.getItems()) {
            if (itemInRoom.getName().equals(name)) {
                item = itemInRoom;
                break;
            }
        }
        if (item != null) {
            player.takeItem(item);
            room.getItems().remove(item);
        }
        return item;
    }

    public Item dropItem(String name) {
        Item itemToDrop = null;
        for (Item item : player.getItem()) {
            if (item.getName().equals(name)) {
                itemToDrop = item;
                break;
            }
        }
        if (itemToDrop != null) {
            player.dropItem(itemToDrop, player.getCurrentRoom());
            player.getCurrentRoom().getItems().add(itemToDrop);
        }
        return itemToDrop;
    }

    public Room goNorth() {
        return player.getGoNorth();
    }
    public Room goWest() {
        return player.getGoWest();
    }

    public Room goEast() {
        return player.getGoEast();
    }
    public Room goSouth() {
        return player.getGoSouth();

    }
    public Room PlayCurrentRoom() {
        return player.getCurrentRoom();
    }
    public void printAdventureInventory() {
        if (player.getItem().isEmpty()) {
            System.out.println("Player has no item in the inventory");
        } else {
            for (Item item : player.getItem()) {
                System.out.println(item.getName() + " " + item.getDescription());
            }
        }
    }
}












