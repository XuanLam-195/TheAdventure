package org.example;

import java.util.Scanner;

public class UserInterface {
    public void startProgram() {
        Scanner sc = new Scanner(System.in);
        AdventureControl adventure = new AdventureControl();

        System.out.println("Welcome To The New Adventure!");
        System.out.println("---------------------");
        System.out.println("You are able to move around by typing \"go north/south/east/west\" or \"go n/w/e/s\"\n" +
                "If you need anything type \"help\"\n");

        System.out.println("You are starting at " + adventure.PlayCurrentRoom().getRoomDescription());
        System.out.print("Which direction would you like to go: n/w/e/s \n");


        String input;
        boolean finish = false;
        while (!finish) {
            System.out.println("Awaiting for your command: ");
            input = sc.nextLine();
            if (input.startsWith("pick")) {
                String[] arrayInput = input.split(" ", 2);
                String name = arrayInput[1];
                Item item = adventure.findAndPick(name);
                if (item == null) {
                    System.out.println("Player can not find the item");
                } else {
                    System.out.println("Player has picked the item");
                }
            } else if (input.startsWith("drop")) {
                String[] arrayInput = input.split(" ", 2);
                String name = arrayInput[1];
                Item item = adventure.dropItem(name);
                if (item == null) {
                    System.out.println("There is no item to drop");
                } else {
                    System.out.println("The item has been dropped");
                }
            } else if (input.startsWith("eat")) {
                String[] arrayInput = input.split(" ", 2);
                String name = arrayInput[1];
                EatResult eatResult = adventure.eatFood(name);
                if (eatResult == EatResult.EAT_HEALTHY_FOOD) {
                    System.out.println("You will get your health restore");
                } else if (eatResult == EatResult.EAT_POISON_FOOD) {
                    System.out.println("You will get damage for your health. Your blood would be lost.");
                } else {
                    System.out.println("The food cannot be found");
                }

            } else if (input.startsWith("equip")) {
                String[] arrayInput = input.split(" ", 2);
                String name = arrayInput[1];
                EquippedResult equippedResult = adventure.equip(name);
                if (equippedResult == EquippedResult.CAN_EQUIP) {
                    System.out.println("You can use this weapon");
                } else if (equippedResult == EquippedResult.ALREADY_EQUIPPED) {
                    System.out.println("Your weapon is already to be used");
                } else if (equippedResult == EquippedResult.NOT_A_WEAPON) {
                    System.out.println("This is not a weapon which you are looking for");
                } else {
                    System.out.println("This weapon is not in your inventory");
                }

            } else if (input.startsWith("attack")) {
                String[] arrayInput = input.split(" ", 2);
                String name = "";
                if(arrayInput.length >= 2 ){
                     name = arrayInput[1];
                }
                AttackResult attackResult = adventure.attack(name);
                if (attackResult == AttackResult.HAS_NO_WEAPON) {
                    System.out.println("You have no weapon to attack your enemy");
                } else if (attackResult == AttackResult.WEAPON_WITHOUT_BULLET) {
                    System.out.println("You can not attack your enemy, because your weapon is emty bullet.");
                } else if (attackResult == AttackResult.ROOM_WITHOUT_ENEMY) {
                    System.out.println("There is not any enemy to attack");
                } else if (attackResult == AttackResult.CANT_FOUND_ENEMY_WITH_NAME) {
                    System.out.println("That enemy can not found");
                } else if (attackResult == AttackResult.ATTACK_AND_ENEMY_DIED) {
                    System.out.println("The enemy died by your attacking");
                } else if (attackResult == AttackResult.ATTACK_AND_ENEMY_ALIVE_COUNTER_ATTACK) {
                    System.out.println("You attack an enemy and get counter attack and you lost your health");
                } else {
                    System.out.println("You died by the enemy's attacking");
                    finish = true;
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
                        System.out.println("You find yourself in a dimly lit chamber." +
                                " The walls are covered in moss and spiderwebs. The air is damp and carries a musty odor." +
                                " A flickering torch casts eerie shadows.");
                    }
                    case "help" -> {
                        System.out.println("The program has these commands:"+ "\n" +
                                "Press n to go to the North" + "\n" +
                                "Press w to go to the West" + "\n" +
                                "Press e to go to the East"+ "\n" +
                                "Press s to go to the South" + "\n" +
                                "Press p <Item Name> to pick the Item" + "\n" +
                                "Press d <Item Name> to drop the Item" + "\n" +
                                "Press e <Food Name> to eat the food"+ "\n" +
                                "Press equip <Weapon Name> to equip the Weapon" + "\n" +
                                "Press attack <Enemy Name> to attack the Enemy"+ "\n" +
                                "Press i to view your Inventory" + "\n" +
                                "Press look to repeat the description of room you are in" + "\n" +
                                "Press h to show your current health" + "\n" +
                                "Press ex to exit the game.");

                    }
                    case "inventory", "i" -> {
                        adventure.printAdventureInventory();
                    }
                    case "health", "h" -> {
                        System.out.println("Player has number of blood: " + adventure.getPlayerHealth());
                    }
                    case "exit", "ex" -> {
                        System.out.println("Quit the game!");
                        finish = true;
                    }
                }
            }
        }
    }
}

