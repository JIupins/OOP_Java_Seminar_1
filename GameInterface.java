package OOP_Java_Seminar_1;

import java.util.ArrayList;

import OOP_Java_Seminar_1.Units.BaseTypeUnit;

public interface GameInterface {

    boolean step(ArrayList<BaseTypeUnit> ownTeam, ArrayList<BaseTypeUnit> enemyTeam);

    String getInfo();
}
