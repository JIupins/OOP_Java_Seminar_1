package OOP_Java_Seminar_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import OOP_Java_Seminar_1.Units.*;

public class AdditionFunctions {
    static Scanner iScan = new Scanner(System.in);

    static Integer numberOfCommand = 1;

    /**
     * 
     * @return - Команда героев (ArrayList)
     */
    public static ArrayList<BaseTypeUnit> createCommand() {
        ArrayList<BaseTypeUnit> command = new ArrayList<>();

        System.out.printf("\nВведите колличество героев в команде %d: ", numberOfCommand);
        int quantityOfHeroes = iScan.nextInt();

        command = AdditionFunctions.createRandomCommand(quantityOfHeroes, numberOfCommand);

        numberOfCommand++;

        return command;
    }

    /**
     * 
     * @param quantityOfHeroes - колличество героев в команде.
     * @param numberOfCommand  - порядковый номер команды.
     * @return Список (ArrayList) с произвольно созданной коммандой.
     */
    public static ArrayList<BaseTypeUnit> createRandomCommand(int quantityOfHeroes, int numberOfCommand) {
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
                    command.add(new Monk("Монах" + " №" + numMonk + " К" + numberOfCommand));
                    break;
                case 1:
                    numWitch++;
                    command.add(new Witch("Колдун" + " №" + numWitch + " К" + numberOfCommand));
                    break;
                case 2:
                    numSniper++;
                    command.add(new Sniper("Снайпер" + " №" + numSniper + " К" + numberOfCommand));
                    break;
                case 3:
                    numArbalester++;
                    command.add(new Arbalester("Арбалетчик" + " №" + numArbalester + " К" + numberOfCommand));
                    break;
                case 4:
                    numBarbarian++;
                    command.add(new Barbarian("Варвар" + " №" + numBarbarian + " К" + numberOfCommand));
                    break;
                case 5:
                    numAssassin++;
                    command.add(new Assassin("Убийца" + " №" + numAssassin + " К" + numberOfCommand));
                    break;
                case 6:
                    numKnight++;
                    command.add(new Knight("Рыцарь" + " №" + numKnight + " К" + numberOfCommand));
                    break;
            }
        }
        return command;
    }

    /**
     * 
     * @param command1 - Атакующая команда.
     * @param command2 - Нападающая команда.
     */
    public static int fight(ArrayList<BaseTypeUnit> command1, ArrayList<BaseTypeUnit> command2) {
        int summariHPCommand = -999;

        System.out.println("Состав атакующей команды: ");
        command1.forEach(unit -> System.out.printf("%d---%s\n", command1.indexOf(unit), unit.getName()));

        System.out.print("Выберите атакующего персонажа: ");
        int numHero1 = iScan.nextInt();

        System.out.println("Состав обороняющейся команды: ");
        command2.forEach(unit -> System.out.printf("%d---%s\n", command2.indexOf(unit), unit.getName()));

        System.out.print("Выберите предполагаемого противника: ");
        int numHero2 = iScan.nextInt();

        if (command1.get(numHero1).getClass().getSimpleName()
                .equals(OOP_Java_Seminar_1.Units.Monk.class.getSimpleName())) {
            System.out.println("\nВыберите вариант действий: " +
                    "\n1 - Лечить члена своей команды" +
                    "\n2 - Атаковать выбранного противника");
            System.out.print("Введите символ операции: ");
            int num = iScan.nextInt();
            switch (num) {
                case 1:
                    ((OOP_Java_Seminar_1.Units.Monk) (command1.get(numHero1))).step(command1);
                    summariHPCommand = AdditionFunctions.defineSummaryHPOfCommand(command1);
                    System.out.printf("Общее здоровье атакующей команды после лечения: %d\n", summariHPCommand);
                    break;
                case 2:
                    command1.get(numHero1).attack(command2.get(numHero2));
                    summariHPCommand = AdditionFunctions.defineSummaryHPOfCommand(command2);
                    System.out.printf("Общее здоровье обороняющейся команды: %d\n", summariHPCommand);
                    break;
            }
        } else {
            command1.get(numHero1).attack(command2.get(numHero2));
            summariHPCommand = AdditionFunctions.defineSummaryHPOfCommand(command2);
            System.out.printf("Общее здоровье обороняющейся команды: %d\n", summariHPCommand);
        }
        return summariHPCommand;
    }

    public static void fightTeamToTeam(ArrayList<BaseTypeUnit> firstCommand,
            ArrayList<BaseTypeUnit> secondCommand) {
        int summariHPfirstCommand = AdditionFunctions.defineSummaryHPOfCommand(firstCommand);
        int summariHPsecondCommand = AdditionFunctions.defineSummaryHPOfCommand(secondCommand);

        do {
            System.out.println("\n____Атака первой команды____");
            summariHPsecondCommand = AdditionFunctions.fight(firstCommand, secondCommand);
            if (summariHPsecondCommand <= 0) {
                break;
            }

            System.out.println("\n____Атака второй команды____");
            summariHPfirstCommand = AdditionFunctions.fight(secondCommand, firstCommand);
            if (summariHPfirstCommand <= 0) {
                break;
            }

        } while (!(summariHPfirstCommand < 1) & !(summariHPsecondCommand < 1));

        if (summariHPfirstCommand > summariHPsecondCommand) {
            System.out.printf(
                    "\n____Победила первая команда! Оставшееся число жизней всех героев: %d____\n",
                    summariHPfirstCommand);
        } else {
            System.out.printf(
                    "\n____Победила вторая команда! Оставшееся число жизней всех героев: %d____\n",
                    summariHPsecondCommand);
        }
    }

    public static void fightWithOneTeam(ArrayList<BaseTypeUnit> firstCommand,
            ArrayList<BaseTypeUnit> secondCommand,
            ArrayList<BaseTypeUnit> commonCommand) {
        Boolean flag4 = true;
        int round = 1;

        while (flag4) {
            Random rnd = new Random();
            int summariHPfirstCommand = AdditionFunctions.defineSummaryHPOfCommand(firstCommand);
            int summariHPsecondCommand = AdditionFunctions.defineSummaryHPOfCommand(secondCommand);

            ArrayList<String> namesOfheroesFirstCommand = new ArrayList<>();
            namesOfheroesFirstCommand = AdditionFunctions.getListOfNames(firstCommand);

            System.out.printf("\n_____Круг №%d_____\n", round++);

            for (int i = 0; i < commonCommand.size(); i++) {
                int index = rnd.nextInt(0, firstCommand.size());

                if (namesOfheroesFirstCommand.contains(commonCommand.get(i).getName())) {
                    commonCommand.get(i).attack(secondCommand.get(index));
                    summariHPsecondCommand = AdditionFunctions.defineSummaryHPOfCommand(secondCommand);
                } else {
                    commonCommand.get(i).attack(firstCommand.get(index));
                    summariHPfirstCommand = AdditionFunctions.defineSummaryHPOfCommand(firstCommand);
                }

                if (summariHPfirstCommand < 1 || summariHPsecondCommand < 1) {
                    if (summariHPfirstCommand > summariHPsecondCommand) {
                        System.out.printf("\n____Победила первая команда! Осталось жизней:%d____\n", summariHPfirstCommand);
                    } else {
                        System.out.printf("\n____Победила вторая команда! Осталось жизней:%d____\n", summariHPsecondCommand);
                    }
                    flag4 = false;
                    break;
                } else {
                    flag4 = true;
                }
            }
            System.out.printf("---Общее здоровье первой команды: %d---\n", summariHPfirstCommand);
            System.out.printf("---Общее здоровье второй команды: %d---\n", summariHPsecondCommand);
        }
    }

    public static ArrayList<String> getListOfNames(ArrayList<BaseTypeUnit> command) {
        ArrayList<String> list = new ArrayList<>();
        command.forEach(u -> list.add(u.getName()));
        return list;
    }

    /**
     * 
     * @param command - Комманда для которой необходимо узнать общее кол-во HP
     *                персонажей.
     * @return - Общее кол-во HP.
     */
    public static int defineSummaryHPOfCommand(ArrayList<BaseTypeUnit> command) {
        int summariHP = 0;
        for (BaseTypeUnit unit : command) {
            summariHP += unit.curentHealth();
        }
        return summariHP;
    }
}