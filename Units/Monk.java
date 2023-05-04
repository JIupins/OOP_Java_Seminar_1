package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Monk extends Mage {

    public Monk(String name) {
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
    public void heal(BaseTypeUnit target) {
        Random rd = new Random();

        int value = rd.nextInt(super.damage[0], super.damage[1]);

        if (this.mana >= value) {
            target.health += value;
            System.out.printf("\n%s: исцелил на %d единиц -> %s\n", this.name, value, target.name);
            this.mana -= value;
        } else {
            System.out.printf("\n%s: у меня недостаточно маны для ислецения -> %s\n", this.name, target.name);
        }
    }

    @Override
    public void step(ArrayList<BaseTypeUnit> list) {
        double minHP = list.get(0).health / list.get(0).maxHealth;
        int unitMinHP = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).health < list.get(i).maxHealth && list.get(i).health / list.get(i).maxHealth < minHP) {
                minHP = list.get(i).health / list.get(i).maxHealth;
                unitMinHP = i;
            }
        }
        if (minHP < 1)
            heal(list.get(unitMinHP));
    }
}