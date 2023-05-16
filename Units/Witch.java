package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;
import java.util.Arrays;

public class Witch extends Mage {

    public Witch(String name, int x, int y) {
        super(name,
                1,
                100,
                30,
                1000,
                new int[] { 2, 5 },
                1,
                3,
                3,
                7,
                7,
                x,
                y,
                true,
                15);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public String getInfo() {
        return String.format(
                "\nType: %s\nName: %s\nLevel: %s\nMax_Level: %s\nHealth: %d\nMax_Health: %d\nDamage: %s\nArmor: %d\nForce: %d\nAgility: %d\nAccuracy: %d\nMana: %d",
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
                super.mana);
    }

    @Override
    public boolean step(ArrayList<BaseTypeUnit> ownTeam, ArrayList<BaseTypeUnit> enemyTeam) {
        for (BaseTypeUnit unit : ownTeam) {
            System.out.printf("%s: Я что-то сделал -> %d!", this.name, unit);
        }
        return true;
    }
}