package org.example;

import java.util.Scanner;

public class UserInterface {
    public void startProgram() {
        Scanner sc = new Scanner(System.in);
        Adventure adventure = new Adventure();

        System.out.println("Welcome To The New Adventure!");
        System.out.println("---------------------");
        System.out.println("You are able to move around by typing \"go north/south/east/west\" or \"go n/w/e/s\"\n" +
                "If you need anything type \"help\"\n");

        System.out.println("You are starting at " + adventure.PlayCurrentRoom().getRoomDescription());
        System.out.print("Which direction would you like to go: n/w/e/s \n");


        String input;
        boolean finish = true;
        while (finish) {
           // System.out.println("awaiting for your command: ");
            input = sc.nextLine();
            if (input.startsWith("pick")) {
                String[] arrayInput = input.split(" ");
                String name = arrayInput[1];
                Item item = adventure.findAndPick(name);
                if (item == null) {
                    System.out.println("Player can not find the item");
                } else {
                    System.out.println("Player has picked the item");
                }
            } else if (input.startsWith("drop")) {
                String[] arrayInput = input.split(" ");
                String name = arrayInput[1];
                Item item = adventure.dropItem(name);
                if (item == null) {
                    System.out.println("There is no item to drop");
                } else {
                    System.out.println("There is an item to pick");
                }
            }else if(input.startsWith("eat")){
                String[] arrayInput = input.split(" ");
                String name = arrayInput[1];
                EatResult eatResult = adventure.eatFood(name);
                if(eatResult == EatResult.EAT_HEALTHY_FOOD){
                    System.out.println("You will get your health restore");
                }else if(eatResult == EatResult.EAT_POISON_FOOD){
                    System.out.println("You will get damage for your health. Your blood would be lost.");
                }else{
                    System.out.println("The food cannot be found");
                }


            } else {
                switch (input) {
                    case "go north", "n" -> {
                        System.out.println(adventure.goNorth());
                    }
                    case "go west", "w" -> {
                        System.out.println(adventure.goWest());
                    }
                    case "go east", "e" -> {
                        System.out.println(adventure.goEast());
                    }
                    case "go south", "s" -> {
                        System.out.println(adventure.goSouth());
                    }
                    case "look" -> {
                        System.out.println(adventure.PlayCurrentRoom());
                    }
                    case "help" -> {
                        System.out.println("This is a room in the game, you can interact with items here!");
                    }
                    case "inventory", "i" -> {
                        adventure.printAdventureInventory();
                    }
                    case "health", "h" -> {
                        System.out.println("Player has number of blood: " + adventure.getPlayerHealth());
                    }
                    case "exit" -> {
                        System.out.println("Quit the game!");
                        finish = false;
                    }
                }
            }
        }
    }
}

