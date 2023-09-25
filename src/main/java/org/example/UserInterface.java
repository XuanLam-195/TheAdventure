package org.example;

import java.util.Scanner;

public class UserInterface {
    public void startProgram() {
        Scanner sc = new Scanner(System.in);
        Adventure adventure = new Adventure();


        System.out.println("Welcome To The New Adventure!");
        System.out.println("---------------------");
        System.out.println("You are able to move around by typing \"go north/south/east/west\" or \"go n/s/e/w\"\n" +

                "If you need anything type \"help\"\n");

        System.out.println("You are starting at " + adventure.getCurrentRoom());
        System.out.print("Which direction would you like to go: n/s/e/w \n");
          String input; 
        input = sc.nextLine();
        while (!input.equalsIgnoreCase("exit")) {

        if (adventure.move(input) == true) {
            System.out.println("Currently you're in" + adventure.getCurrentRoom());
            System.out.print("Which direction would you like to go: n/s/e/w\n");
            input = sc.nextLine();

        }else{

                input = sc.nextLine();
            }
            
        }

          




    }
}
