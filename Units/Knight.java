package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Infantryman {

    public Knight(String name) {
        super(name,
                1,
                100,
                50,
                1000,
                new int[] { 1, 4 },
                2,
                4,
                3,
                2,
                6,
                1);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public String getInfo() {
        return String.format(
                "\nType: %s\nName: %s\nLevel: %s\nMax_Level: %s\nHealth: %d\nMax_Health: %d\nDamage: %s\nArmor: %d\nForce: %d\nAgility: %d\nAccuracy: %d\nQuantity_Weapons: %d",
                super.getClass().getSimpleName(),
                super.name,
                super.level,
                super.maxLevel,
                super.health,
                super.maxHealth,
                Arrays.toString(super.damage).replaceAll("[,\\[\\]]", "").replace(" ", "-"),
                super.armor,
                super.force,
                super.agility,
                super.accuracy,
                super.quantityWeapons);
    }

    @Override
    public void step(ArrayList<BaseTypeUnit> list) {
        for (BaseTypeUnit unit : list) {
            System.out.printf("%s: Я что-то сделал -> %d!", this.name, unit);
        }
    }
}