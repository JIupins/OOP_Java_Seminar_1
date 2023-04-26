package OOP_Java_Seminar_1.Units;

import OOP_Java_Seminar_1.GameInterface;

public abstract class BaseTypeUnit implements GameInterface {
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