package org.example;

public class AdventureControl {
    private Player player;



    public AdventureControl() {
        CreateMap createMap = new CreateMap();
        createMap.Create();
        this.player = new Player("John", createMap.getRoom1());
    }

    public Item findAndPick(String name) {
        Item item = null;
        Room room = player.getCurrentRoom();
        for (Item itemInRoom : room.getItems()) {
            if (itemInRoom.getName().equalsIgnoreCase(name)) {
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
        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(name)) {
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
            if (foodInRoom.getName().equalsIgnoreCase(name)) {
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
        for (Item foodInInventory : player.getInventory()) {
            if (foodInInventory.getName().equalsIgnoreCase(name)) {
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
        } else {
            return EatResult.FOOD_NOT_FOUND;
        }
    }

    public EquippedResult equip(String name) {
        Weapon weapon = player.getWeapon();
        if (weapon == null || !weapon.getName().equals(name)) {
            for (Item item : player.getInventory()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    if (item instanceof Weapon) {
                        weapon = (Weapon) item;
                        player.setWeapon(weapon);
                        return EquippedResult.CAN_EQUIP;
                    } else {
                        return EquippedResult.NOT_A_WEAPON;
                    }
                }
            }
            return EquippedResult.WEAPON_NOT_FOUND;
        } else {
            return EquippedResult.ALREADY_EQUIPPED;
        }

    }

    public AttackResult attack(String enemyName) {
        if (player.getWeapon() == null) {
            return AttackResult.HAS_NO_WEAPON;
        } else {
            if (!player.getWeapon().canUse()) {
                return AttackResult.WEAPON_WITHOUT_BULLET;
            } else {
                Room room = player.getCurrentRoom();
                if (room.getEnemies().isEmpty()) {
                    return AttackResult.ROOM_WITHOUT_ENEMY;
                }
                Enemy enemy = null;
                if (enemyName == null || enemyName.isEmpty()) {
                    enemy = room.getEnemies().get(0);
                } else {
                    for (Enemy enemyInRoom : room.getEnemies()) {
                        if (enemyInRoom.getName().equalsIgnoreCase(enemyName)) {
                            enemy = enemyInRoom;
                            break;
                        }
                    }
                    if (enemy == null) {
                        return AttackResult.CANT_FOUND_ENEMY_WITH_NAME;
                    } else {
                        Weapon weapon = player.getWeapon();
                        weapon.attack();
                        enemy.setHealthLevel(enemy.getHealthLevel() - weapon.getDamage());
                        if (!enemy.isAlive()) {
                            room.getItems().add(enemy.getWeapon());
                            room.getEnemies().remove(enemy);
                            return AttackResult.ATTACK_AND_ENEMY_DIED;
                        } else {
                            Weapon enemyWeapon = enemy.getWeapon();
                            enemyWeapon.attack();
                            player.setHealth(player.getHealth() - enemyWeapon.getDamage());
                            if (!player.isAlive()) {
                                return AttackResult.ENEMY_COUNTER_ATTACK_AND_PLAYER_DIED;
                            } else {
                                return AttackResult.ATTACK_AND_ENEMY_ALIVE_COUNTER_ATTACK;
                            }
                        }
                    }
                }

            }

        }
        return AttackResult.HAS_NO_WEAPON;
    }

    public int getPlayerHealth() {
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
        if (player.getInventory().isEmpty()) {
            System.out.println("Player has no item in the inventory");
        } else {
            for (Item item : player.getInventory()) {
                System.out.println(item.getName() + " " + item.getDescription());
            }
        }
    }
}












