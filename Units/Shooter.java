package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;

public abstract class Shooter extends BaseTypeUnit {
    protected int ammunition;

    protected Shooter(String name, int level, int maxLevel, int health, int maxHealth, int[] damage, int armor,
            int force, int agility, int accuracy, int initiative, int x, int y, boolean availability, int ammunition) {
        super(name, level, maxLevel, health, damage, armor, force, agility, accuracy, initiative, x, y, availability);
        this.ammunition = ammunition;
    }

    @Override
    public boolean step(ArrayList<BaseTypeUnit> ownTeam, ArrayList<BaseTypeUnit> enemyTeam) {
        if (armor < 1) {
            return false;
        }

        boolean flag1 = false;

        for (BaseTypeUnit unit : ownTeam) {
            if (unit.getClass().getSimpleName().equals(Knecht.class.getSimpleName())) {
                Knecht knecht = (Knecht) unit;
                if (health > 0 && (knecht.getAvailability() && knecht.getAmmunition() == 1)) {
                    knecht.setAmmunition(0);
                    flag1 = true;
                    break;
                } else {
                    flag1 = false;
                }
            }
        }

        float minDistance = Float.MAX_VALUE;
        BaseTypeUnit target = null;
        for (BaseTypeUnit unit : enemyTeam) {
            if (unit.curentHealth() > 0) {
                float distance = super.coordinates.findDistance(unit.coordinates);
                if (distance <= minDistance) {
                    minDistance = distance;
                    target = unit;
                }
            }
        }

        System.out.printf("%s: Расстояние до ближайшего живого противника -> %.2f метров.\n", this.name, minDistance);
        super.attack(target);

        if (!flag1) {
            --ammunition;
            System.out.printf("%s: Я потратил 1 стрелу, так как нет доступных крестьян. Стрел осталось -> %d\n",
                    this.name, ammunition);
        } else {
            System.out.printf("%s: Я не трачу стрелы, мне помог крестьянин. Стрел осталось -> %d\n", this.name,
                    ammunition);
        }
        return true;
    }
}
