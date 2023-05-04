package OOP_Java_Seminar_1;

import java.util.ArrayList;

import OOP_Java_Seminar_1.Units.BaseTypeUnit;

public interface GameInterface {

    void  step(ArrayList<BaseTypeUnit> list);
    String getInfo();
}


