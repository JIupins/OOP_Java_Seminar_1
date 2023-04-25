/*Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo();
Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал информацию о персонаже.
Создать два списка в классе main. В каждый список добавить по десять экземнляров наследников BaseHero.
В main пройти по спискам и вызвать у всех персонажей getInfo.
*/

package OOP_Java_Seminar_1;

import java.util.ArrayList;

import OOP_Java_Seminar_1.Units.*;

public class Game {
    public static void main(String[] args) {

        ArrayList<BaseTypeUnit> firstCommand = new ArrayList<>();
        ArrayList<BaseTypeUnit> secondCommand = new ArrayList<>();

        firstCommand = AdditionFunctions.createRandomCommand(10, 1);
        secondCommand = AdditionFunctions.createRandomCommand(10, 2);

        firstCommand.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println("\n--------------");
        secondCommand.forEach(unit -> System.out.println(unit.getInfo()));
    }
}