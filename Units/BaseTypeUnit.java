package OOP_Java_Seminar_1.Units;

import java.util.Arrays;

public class BaseTypeUnit {
    protected String name;
    protected int level;
    protected int maxLevel;
    protected int health;
    protected int maxHealth;
    protected int[] damage;
    protected int armor;
    protected int force;
    protected int agility;
    protected int accuracy;

    protected BaseTypeUnit(String name, int level, int maxLevel, int health, int maxHealth, int[] damage, int armor,
            int force, int agility, int accuracy) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxLevel;
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.armor = armor;
        this.force = force;
        this.agility = agility;
        this.accuracy = accuracy;
    }

    protected String getInfo() {
        return String.format(
                "\nType: %s\nName: %s\nLevel: %s\nMax_Level: %s\nHealth: %d\nMax_Health: %d\nDamage: %s\nArmor: %d\nForce: %d\nAgility: %d\nAccuracy: %d\n",
                this.getClass().getSimpleName(),
                this.name,
                this.level,
                this.maxLevel,
                this.health,
                this.maxHealth,
                Arrays.toString(this.damage).replaceAll("[,\\[\\]]", "").replace(" ", "name"),
                this.armor,
                this.force,
                this.agility,
                this.accuracy);
    }

    public void attack() {
        System.out.println("Я атакую!");
    }

    public void defend() {
        System.out.println("Я защищаюсь!");
    }

    protected void getDamage() {
        System.out.println("Я получил урон!");
    }

    public void heal() {
        System.out.println("Я лечусь!");
    }

    public void move() {
        System.out.println("Я двигаюсь!");
    }
}