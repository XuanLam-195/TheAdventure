package org.example;

public class Food extends Item{

      int healthBonus;

    public int getHealthBonus() {
        return healthBonus;
    }

    public Food(String name, String description, int healthBonus) {
        super(name, description);
        this.healthBonus = healthBonus;
    }
}
