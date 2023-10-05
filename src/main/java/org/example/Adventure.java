package org.example;

import java.util.List;

public class Adventure {
    private Player player;
    public Adventure() {
        CreateMap createMap = new CreateMap();
        createMap.Create();
        this.player = new Player("John",  createMap.getRoom1());
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
    public EatResult eatFood(String name) {
        Food food = null;
        Room room = player.getCurrentRoom();
        for (Item foodInRoom : room.getItems()) {
            if (foodInRoom.getName().equals(name)) {
                food = (Food) foodInRoom;
                break;
            }
        }
        if (food != null) {
            player.eatFood(food, room);
            if (food.getHealthBonus() < 0) {
                return EatResult.EAT_POISON_FOOD;
            } else {
                return EatResult.EAT_HEALTHY_FOOD;
            }
        }
        for (Item foodInInventory : player.getItem()) {
            if (foodInInventory.getName().equals(name)) {
                food = (Food) foodInInventory;
                break;
            }
        }
        if (food != null) {
            player.eatFood(food);
            if (food.getHealthBonus() < 0) {
                return EatResult.EAT_POISON_FOOD;
            } else {
                return EatResult.EAT_HEALTHY_FOOD;
            }
        }else{
            return  EatResult.FOOD_NOT_FOUND;
        }
    }
        public int getPlayerHealth(){
            return player.getHealth();
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












