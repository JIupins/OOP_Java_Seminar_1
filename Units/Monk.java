package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Monk extends Mage {

    public Monk(String name, int x, int y) {
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
                20);
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
    public boolean heal(BaseTypeUnit target) {
        Random rd = new Random();

        int value = rd.nextInt(super.damage[0], super.damage[1]);

        if (this.mana >= value) {
            target.health += value;
            System.out.printf("%s: исцелил на %d единиц -> %s\n", this.name, value, target.name);
            this.mana -= value;
            return true;
        } else {
            System.out.printf("%s: у меня недостаточно маны для ислецения -> %s\n", this.name, target.name);
            return false;
        }
    }

    @Override
    public boolean step(ArrayList<BaseTypeUnit> ownTeam, ArrayList<BaseTypeUnit> enemyTeam) {
        double minHP = ownTeam.get(0).health / ownTeam.get(0).maxHealth;
        int unitMinHP = 0;
        Boolean value = false;

        for (int i = 1; i < ownTeam.size(); i++) {
            if (ownTeam.get(i).health < ownTeam.get(i).maxHealth
                    && ownTeam.get(i).health / ownTeam.get(i).maxHealth < minHP) {
                minHP = ownTeam.get(i).health / ownTeam.get(i).maxHealth;
                unitMinHP = i;
            }
        }
        if (minHP < 1) {
            value = heal(ownTeam.get(unitMinHP));
        }
        return value;
    }
}