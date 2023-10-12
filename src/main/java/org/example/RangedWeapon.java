package org.example;

public class RangedWeapon extends Weapon {
    private int remainingUse;

    public RangedWeapon(String name, String description, int remainingUse, int damage) {
        super(name, description, damage);
        this.remainingUse = remainingUse;
    }

    @Override
    public boolean canUse() {
        if (remainingUse > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void attack() {
        remainingUse = remainingUse - 1;
    }
}
