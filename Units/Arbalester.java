package OOP_Java_Seminar_1.Units;

import java.util.Arrays;

public class Arbalester extends Shooter {
    protected boolean availability;

    public Arbalester(String name, int x, int y) {
        super(name,
                1,
                100,
                30,
                1000,
                new int[] { 2, 6 },
                1,
                3,
                3,
                4,
                8,
                x,
                y,
                true,
                20);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public String getInfo() {
        return String.format(
                "\nType: %s\nName: %s\nLevel: %s\nMax_Level: %s\nHealth: %d\nMax_Health: %d\nDamage: %s\nArmor: %d\nForce: %d\nAgility: %d\nAccuracy: %d\nAmmunition: %d",
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
                super.ammunition);
    }
}