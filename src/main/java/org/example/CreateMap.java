package org.example;

public class CreateMap {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;

    public Room getRoom1() {
        return room1;
    }

    public void Create() {
        room1 = new Room("Room 1 : Hidden Chamber ", "Secret chamber with ancient artifacts.");
        room2 = new Room("Room 2 : Abandoned Laboratory", "Eerie lab with puzzles and experiments.");
        room3 = new Room("Room 3 : Cryptic Library ", "Dusty library with riddles and clues.");
        room4 = new Room("Room 4: Haunted Attic ", "Spooky attic with ghostly puzzles.");
        room5 = new Room("Room 5: Underground ", "Maze-like tunnels with traps and treasures.");
        room6 = new Room("Room 6: Time-Travelling Chamber ", "Alters the game's timeline.");
        room7 = new Room("Room 7: Alchemy Workshop ", "Crafting and potion-making room");
        room8 = new Room("Room 8: Alien Encounter Room ", "High-tech room with alien puzzles");
        room9 = new Room("Room 9: Dreamscape Chamber ", "Surreal room with abstract challenges.");

        room1.setConnections(null, null, room2, room4);
        room2.setConnections(null, room1, room3, null);
        room3.setConnections(null, room2, null, room6);
        room4.setConnections(room1, null, null, room7);
        room5.setConnections(null, null, null, room8);
        room6.setConnections(room3, null, null, room9);
        room7.setConnections(room4, null, room8, null);
        room8.setConnections(room5, room7, room9, null);
        room9.setConnections(room6, room8, null, null);
        CreateItems();
        Food();
    }

    public void CreateItems() {
        Item sword = new Item("Sword", "A basic melee weapon.");
        Item bow = new Item("Bow", "Ranged weapon with arrows.");
        Item dagger = new Item("Dagger", "A concealed, lightweight weapon.");
        Item crossbow = new Item("Crossbow", "A powerful ranged weapon.");
        Item gemstone = new Item("Gemstone", "A valuable jewel");
        Item torch = new Item("Torch", "Provides light in dark areas.");
        Item spyglass = new Item("Spyglass", " Allows the player to see distant objects clearly.");
        Item map = new Item("Map", "Reveals the player's current location.");
        Item mysteriousKey = new Item("Mysterious Key", "Opens a hidden door or chest.");

        room1.getItems().add(sword);
        room2.getItems().add(bow);
        room3.getItems().add(dagger);
        room4.getItems().add(crossbow);
        room5.getItems().add(gemstone);
        room6.getItems().add(torch);
        room7.getItems().add(spyglass);
        room8.getItems().add(map);
        room9.getItems().add(mysteriousKey);

    }
    public void Food(){
        Food apple = new Food("Apple", "A fresh red apple!", 70);
        Food bread = new Food("Bread", "A loaf og bread!", 45);
        Food beef = new Food("Beef", "A half kilo of fresh beef!", -100);
        Food eggs = new Food("Eggs", "A dozen og egg!", 120);
        Food pasta = new Food("Pasta", "A delicious dish od pasta!", -200);
        Food orange  = new Food("Orange", "A huge fresh orange!", 80);
        Food chickenNuggets  = new Food("Chiken nuggets", "A huge pack of chicken nuggets!", -170);
        Food pizza = new Food("Pizza", "A huge piece of pizza!", 40);
        Food rice = new Food("Rice", "A huge bow of rice!", 20);
        room2.getItems().add(apple);
        room2.getItems().add(bread);
        room3.getItems().add(beef);
        room4.getItems().add(eggs);
        room5.getItems().add(pasta);
        room6.getItems().add(orange);
        room7.getItems().add(chickenNuggets);
        room8.getItems().add(pizza);
        room9.getItems().add(rice);

    }
}
