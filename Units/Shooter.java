package OOP_Java_Seminar_1.Units;

public abstract class Shooter extends BaseTypeUnit {
    protected int ammunition;

    protected Shooter(String name, int level, int maxLevel, int health, int maxHealth, int[] damage, int armor,
            int force, int agility, int accuracy, int initiative, int ammunition) {
        super(name, level, maxLevel, health, damage, armor, force, agility, accuracy, initiative);
        this.ammunition = ammunition;
    }
}