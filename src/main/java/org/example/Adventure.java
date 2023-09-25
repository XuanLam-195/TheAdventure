package org.example;

public class Adventure {
    private Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Adventure() {
        Room room1 = new Room("Room 1 : Hidden Chamber ", "Secret chamber with ancient artifacts.");
        Room room2 = new Room("Room 2 : Abandoned Laboratory", " Eerie lab with puzzles and experiments.");
        Room room3 = new Room("Room 3 : Cryptic Library ", " Dusty library with riddles and clues.");
        Room room4 = new Room("Room 4: Haunted Attic ", "Spooky attic with ghostly puzzles.");
        Room room5 = new Room("Room 5: Underground ", "Maze-like tunnels with traps and treasures.");
        Room room6 = new Room("Room 6: Time-Travelling Chamber ", " Alters the game's timeline.");
        Room room7 = new Room("Room 7: Alchemy Workshop ", "Crafting and potion-making room");
        Room room8 = new Room("Room 8: Alien Encounter Room ", "High-tech room with alien puzzles");
        Room room9 = new Room("Room 9: Dreamscape Chamber ", "Surreal room with abstract challenges.");

        room1.setConnections(null, null, room2, room4);
        room2.setConnections(null, room1, room3, null);
        room3.setConnections(null, room2, null, room4);
        room4.setConnections(room1, null, null, room7);
        room5.setConnections(null, null, null, room8);
        room6.setConnections(room3, null, null, room9);
        room7.setConnections(room4, null, room8, null);
        room8.setConnections(room5, room7, room9, null);
        room9.setConnections(room6, room9, null, null);

        currentRoom = room1;
    }

    public boolean move(String direction) {

        Room nextRoom = null;

        switch (direction) {
            case "go north", "n"-> {
                nextRoom = currentRoom.getGoNorth();
            }
            case "go west", "w"-> {
                nextRoom = currentRoom.getGoWest();
            }
            case "go east", "e"-> {
                nextRoom = currentRoom.getGoEast();
            }
            case "go south", "s"-> {
                nextRoom = currentRoom.getGoSouth();
            }
            case "look"-> {
                System.out.println(currentRoom.getRoomDescription() + " " + currentRoom.getRoomName());
            }
            case "help"-> {
                System.out.println("You will get the intruction and overview a possible commando");
            }
            case "exit"-> {
                System.out.println("quit the game");
                break;
            }
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
        } else {
            currentRoom = getCurrentRoom();
            System.out.println("You can not go this way. Try again.");
            return false;

        }
return true;
    }

}







