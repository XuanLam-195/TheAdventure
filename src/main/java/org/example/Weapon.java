package org.example;

public abstract class Weapon extends Item {

    private int damage;

    public int getDamage() {
        return damage;
    }

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    public abstract boolean canUse();

    public abstract void attack();

}


