package OOP_Java_Seminar_1.Units;

public class Infantryman extends BaseTypeUnit {
    protected int quantityWeapons;

    protected Infantryman(String name, int level, int maxLevel, int health, int maxHealth, int[] damage, int armor,
            int force, int agility, int accuracy, int quantityWeapons) {
        super(name, level, maxLevel, health, maxHealth, damage, armor, force, agility, accuracy);
        this.quantityWeapons = quantityWeapons;
    }
}