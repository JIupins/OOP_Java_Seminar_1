package OOP_Java_Seminar_1.Units;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import OOP_Java_Seminar_1.AdditionFunctions;

public abstract class Infantryman extends BaseTypeUnit {
    protected int quantityWeapons;

    protected Infantryman(String name, int level, int maxLevel, int health, int maxHealth, int[] damage, int armor,
            int force, int agility, int accuracy, int initiative, int x, int y, boolean availability,
            int quantityWeapons) {
        super(name, level, maxLevel, health, damage, armor, force, agility, accuracy, initiative, x, y, availability);
        this.quantityWeapons = quantityWeapons;
    }

    @Override
    public boolean step(ArrayList<BaseTypeUnit> ownTeam, ArrayList<BaseTypeUnit> enemyTeam) {
        if (curentHealth() < 1) {
            return false;
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

        int CoordHeroX = super.coordinates.getValues()[0];
        int CoordHeroY = super.coordinates.getValues()[1];
        int CoordEnemyX = target.coordinates.getValues()[0];
        int CoordEnemyY = target.coordinates.getValues()[1];

        Map<String, String> ListCoordinatesOwnTeam = new HashMap<>(
                AdditionFunctions.getCoordinatsHeroesOfCommand(ownTeam));
        Map<String, String> ListCoordinatesEnemyTeam = new HashMap<>(
                AdditionFunctions.getCoordinatsHeroesOfCommand(enemyTeam));

        Map<String, String> ListCoordinatesCommons = new HashMap<>();
        ListCoordinatesCommons.putAll(ListCoordinatesOwnTeam);
        ListCoordinatesCommons.putAll(ListCoordinatesEnemyTeam);

        int[][] listEmptyCordinats = new int[3][1];

        if ((CoordHeroX == CoordEnemyX && Math.abs(CoordHeroY - CoordEnemyY) < 2) || // если близко то атакуем
                (CoordHeroY == CoordEnemyY && Math.abs(CoordHeroX - CoordEnemyX) < 2)) {
            super.attack(target);
        } else {
            listEmptyCordinats = AdditionFunctions.getlListEmptyCoordinats(this.coordinates.getValues(),
                    ListCoordinatesCommons);
            int[] nearestCoordinates = AdditionFunctions.defineShortDistance(target.getCoordinates(),
                    listEmptyCordinats);
            this.coordinates.setValues(nearestCoordinates);
        }
        return true;
    }
}