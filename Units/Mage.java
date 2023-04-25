package OOP_Java_Seminar_1.Units;

public abstract class Mage extends BaseTypeUnit {
    protected int mana;

    protected Mage(String name, int level, int maxLevel, int health, int maxHealth, int[] damage, int armor, int force,
            int agility, int accuracy, int mana) {
        super(name, level, maxLevel, health, maxHealth, damage, armor, force, agility, accuracy);
        this.mana = mana;
    }
}