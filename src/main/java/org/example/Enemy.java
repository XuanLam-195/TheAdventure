package org.example;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    private String name;
    private String description;

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    private int healthLevel;
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public boolean isAlive() {
        if (healthLevel > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Enemy(String name, String description, int healthLevel, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.healthLevel = healthLevel;
        this.weapon = weapon;
    }
}
