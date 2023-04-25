package OOP_Java_Seminar_1;

import java.util.ArrayList;
import java.util.Random;

import OOP_Java_Seminar_1.Units.*;

public class AdditionFunctions {
    public static ArrayList<BaseTypeUnit> createRandomCommand(int quantityOfHeroes, int numberOfCommnd) {
        ArrayList<BaseTypeUnit> command = new ArrayList<>();
        Random rnd = new Random();
        int numberOfHero;
        int numMonk = 0;
        int numWitch = 0;
        int numSniper = 0;
        int numArbalester = 0;
        int numBarbarian = 0;
        int numAssassin = 0;
        int numKnight = 0;

        for (int unit = 0; unit < quantityOfHeroes; unit++) {
            numberOfHero = rnd.nextInt(0, 7);

            switch (numberOfHero) {
                case 0:
                    numMonk++;
                    command.add(new Monk("Монах" + " №" + numMonk + " К" + numberOfCommnd));
                    break;
                case 1:
                    numWitch++;
                    command.add(new Witch("Колдун" + " №" + numWitch + " К" + numberOfCommnd));
                    break;
                case 2:
                    numSniper++;
                    command.add(new Sniper("Снайпер" + " №" + numSniper + " К" + numberOfCommnd));
                    break;
                case 3:
                    numArbalester++;
                    command.add(new Arbalester("Арбалетчик" + " №" + numArbalester + " К" + numberOfCommnd));
                    break;
                case 4:
                    numBarbarian++;
                    command.add(new Barbarian("Варвар" + " №" + numBarbarian + " К" + numberOfCommnd));
                    break;
                case 5:
                    numAssassin++;
                    command.add(new Assassin("Убийца" + " №" + numAssassin + " К" + numberOfCommnd));
                    break;
                case 6:
                    numKnight++;
                    command.add(new Knight("Рыцарь" + " №" + numKnight + " К" + numberOfCommnd));
                    break;
            }
        }
        return command;
    }
}