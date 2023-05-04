package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;
import java.util.Random;

import OOP_Java_Seminar_1.GameInterface;

public abstract class BaseTypeUnit implements GameInterface, Comparable<BaseTypeUnit> {
    protected String name;
    protected int level;
    protected int maxLevel;
    protected int health;
    protected int maxHealth = health;
    protected int[] damage;
    protected int armor;
    protected int force;
    protected int agility;
    protected int accuracy;
    protected int initiative;

    protected BaseTypeUnit(String name, int level, int maxLevel, int health, int[] damage, int armor,
            int force, int agility, int accuracy, int initiative) {
        this.name = name;
        this.level = level;
        this.maxLevel = maxLevel;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.armor = armor;
        this.force = force;
        this.agility = agility;
        this.accuracy = accuracy;
        this.initiative = initiative;
    }

    public int curentHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void attack(BaseTypeUnit... target) {
        for (BaseTypeUnit unit : target) {
            System.out.printf("%s: Я атакую -> %s\n", this.name, unit.name);
            unit.getDamage(new Random().nextInt(this.damage[0], this.damage[1] + 1));
        }
    }

    public void defend() {
        System.out.println("Я защищаюсь!");
    }

    protected void getDamage(int value) {
        System.out.printf("%s: Я получил урон -> %d\n", this.name, value);
        this.health -= value;
    }

    public void heal(BaseTypeUnit target) {
        System.out.println("Я лечусь!");
    }

    public void move() {
        System.out.println("Я двигаюсь!");
    }

    public void step(ArrayList<BaseTypeUnit> list) {
        System.out.println("Я что-то делаю!");
    }

    @Override
    public int compareTo(BaseTypeUnit o) {
        return o.initiative - this.initiative;
    }
}