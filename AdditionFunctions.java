package OOP_Java_Seminar_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import OOP_Java_Seminar_1.Units.*;

public class AdditionFunctions {
    static Scanner iScan = new Scanner(System.in);

    static Integer numberOfCommand = 1;

    public static ArrayList<BaseTypeUnit> createCommand() {
        ArrayList<BaseTypeUnit> command = new ArrayList<>();
        String quantityOfHeroes1;
        Integer quantityOfHeroes2 = null;
        String choiceOfHeroes;

        boolean flag5 = true;
        while (flag5) {
            System.out.printf("\nВведите колличество героев в команде %d: ", numberOfCommand);
            quantityOfHeroes1 = iScan.next();
            if (isNumber(quantityOfHeroes1)) {
                flag5 = false;
                quantityOfHeroes2 = Integer.parseInt(quantityOfHeroes1);
            } else {
                System.out.println("\nСимвол введен неправильно. Повторите ввод.");
                flag5 = true;
            }
        }

        boolean flag6 = true;
        while (flag6) {
            System.out.printf("\nВы хотите выбрать состав команды №%d:?\nY --> Да\nN --> Нет\nВведите: ",
                    numberOfCommand);
            choiceOfHeroes = iScan.next().toLowerCase();
            if (choiceOfHeroes.equals("y") || choiceOfHeroes.equals("n")) {
                command = AdditionFunctions.createRandomCommand(quantityOfHeroes2, numberOfCommand, choiceOfHeroes);
                flag6 = false;
            } else {
                System.out.println("\nСимвол введен неправильно. Повторите ввод.");
                flag6 = true;
            }
        }

        numberOfCommand++;

        return command;
    }

    public static ArrayList<BaseTypeUnit> createRandomCommand(int quantityOfHeroes, int numberOfCommand,
            String choiceOfHeroes) {
        System.out.println(quantityOfHeroes);
        ArrayList<BaseTypeUnit> command = new ArrayList<>();
        Random rnd = new Random();
        char numberOfHero = 0;
        int numMonk = 0;
        int numWitch = 0;
        int numSniper = 0;
        int numArbalester = 0;
        int numBarbarian = 0;
        int numAssassin = 0;
        int numKnight = 0;
        int numKnecht = 0;

        int positionX;
        int positionY;
        if (numberOfCommand > 1) {
            positionY = 10;
        } else {
            positionY = 1;
        }

        for (int unit = 1; unit < quantityOfHeroes + 1; unit++) {
            if (choiceOfHeroes.equals("y")) {
                boolean flag6 = true;
                while (flag6) {
                    System.out.printf("\nВыберите персонажа:" +
                            "\n1 - Монах" +
                            "\n2 - Колдун" +
                            "\n3 - Снайпер" +
                            "\n4 - Арбалетчик" +
                            "\n5 - Варвар" +
                            "\n6 - Убийца" +
                            "\n7 - Рыцарь" +
                            "\n8 - Кнехт(крестьянин)" +
                            "\nВведите символ операции: ");
                    numberOfHero = iScan.next().charAt(0);
                    if (Character.isDigit(numberOfHero)) {
                        flag6 = false;
                    } else {
                        flag6 = true;
                    }
                }
            } else {
                numberOfHero = Integer.toString(rnd.nextInt(1, 9)).charAt(0);
            }
            positionX = unit;

            switch (numberOfHero) {
                case '1':
                    numMonk++;
                    command.add(new Monk("Монах" + " №" + numMonk + " К" + numberOfCommand, positionX, positionY));
                    break;
                case '2':
                    numWitch++;
                    command.add(new Witch("Колдун" + " №" + numWitch + " К" + numberOfCommand, positionX, positionY));
                    break;
                case '3':
                    numSniper++;
                    command.add(
                            new Sniper("Снайпер" + " №" + numSniper + " К" + numberOfCommand, positionX, positionY));
                    break;
                case '4':
                    numArbalester++;
                    command.add(new Arbalester("Арбалетчик" + " №" + numArbalester + " К" + numberOfCommand, positionX,
                            positionY));
                    break;
                case '5':
                    numBarbarian++;
                    command.add(new Barbarian("Варвар" + " №" + numBarbarian + " К" + numberOfCommand, positionX,
                            positionY));
                    break;
                case '6':
                    numAssassin++;
                    command.add(
                            new Assassin("Убийца" + " №" + numAssassin + " К" + numberOfCommand, positionX, positionY));
                    break;
                case '7':
                    numKnight++;
                    command.add(new Knight("Рыцарь" + " №" + numKnight + " К" + numberOfCommand, positionX, positionY));
                    break;
                case '8':
                    numKnecht++;
                    command.add(new Knecht("Кнехт" + " №" + numKnecht + " К" + numberOfCommand, positionX, positionY));
                    break;
                default:
                    System.out.println("Символ введен неверно.");
                    break;

            }
        }
        return command;
    }

    public static int fight(ArrayList<BaseTypeUnit> ownTeam, ArrayList<BaseTypeUnit> enemyTeam) {
        int summariHPCommand = -999;

        System.out.println("Состав атакующей команды: ");
        for (BaseTypeUnit unit : ownTeam) {
            if (unit.curentHealth() > 0) {
                System.out.printf("%d---%s\n", ownTeam.indexOf(unit), unit.getName());
            }
        }

        System.out.print("Выберите атакующего персонажа: ");
        int numHero1 = iScan.nextInt();

        System.out.println("Состав обороняющейся команды: ");
        for (BaseTypeUnit unit : enemyTeam) {
            if (unit.curentHealth() > 0) {
                System.out.printf("%d---%s\n", enemyTeam.indexOf(unit), unit.getName());
            }
        }

        System.out.print("Выберите предполагаемого противника: ");
        int numHero2 = iScan.nextInt();

        if (ownTeam.get(numHero1).getClass().getSimpleName()
                .equals(Monk.class.getSimpleName())) {
            System.out.println("\nВыберите вариант действий: " +
                    "\n1 - Лечить члена своей команды" +
                    "\n2 - Атаковать выбранного противника");
            System.out.print("Введите символ операции: ");
            int num = iScan.nextInt();
            switch (num) {
                case 1:
                    ((OOP_Java_Seminar_1.Units.Monk) (ownTeam.get(numHero1))).step(ownTeam, enemyTeam);
                    summariHPCommand = AdditionFunctions.defineSummaryHPOfCommand(ownTeam);
                    System.out.printf("Общее здоровье атакующей команды после лечения: %d\n", summariHPCommand);
                    break;
                case 2:
                    ownTeam.get(numHero1).attack(enemyTeam.get(numHero2));
                    if (enemyTeam.get(numHero2).curentHealth() <= 0) {
                        enemyTeam.get(numHero2).setAvailability(false);
                    }
                    summariHPCommand = AdditionFunctions.defineSummaryHPOfCommand(enemyTeam);
                    System.out.printf("Общее здоровье обороняющейся команды: %d\n", summariHPCommand);
                    break;
            }
        } else {
            System.out.println("Не сработал Shooter");
            ownTeam.get(numHero1).attack(enemyTeam.get(numHero2));
            summariHPCommand = AdditionFunctions.defineSummaryHPOfCommand(enemyTeam);
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
            int summariHPfirstCommand = AdditionFunctions.defineSummaryHPOfCommand(firstCommand);
            int summariHPsecondCommand = AdditionFunctions.defineSummaryHPOfCommand(secondCommand);

            ArrayList<String> namesOfheroesFirstCommand = new ArrayList<>();
            namesOfheroesFirstCommand = AdditionFunctions.getListOfNames(firstCommand);

            System.out.printf("\n_____Круг №%d_____\n", round++);

            for (int i = 0; i < commonCommand.size();) {
                int indexFirstCommand = defineIndexOfAvailableHero(firstCommand);
                int indexSecondCommand = defineIndexOfAvailableHero(secondCommand);

                if (namesOfheroesFirstCommand.contains(commonCommand.get(i).getName())) {
                    if (commonCommand.get(i).getClass().getSimpleName().equals(Monk.class.getSimpleName()) ||
                            Shooter.class.isAssignableFrom(commonCommand.get(i).getClass())) {
                        Boolean value = commonCommand.get(i).step(firstCommand, secondCommand);
                        i++;
                        if (!value) {
                            commonCommand.get(i).attack(secondCommand.get(indexSecondCommand));
                            i = clearListOfHeroes(commonCommand, secondCommand, indexSecondCommand, i);
                        }
                    } else {
                        commonCommand.get(i).attack(secondCommand.get(indexSecondCommand));
                        i = clearListOfHeroes(commonCommand, secondCommand, indexSecondCommand, i);
                    }
                    summariHPsecondCommand = AdditionFunctions.defineSummaryHPOfCommand(secondCommand);
                } else {
                    if (commonCommand.get(i).getClass().getSimpleName().equals(Monk.class.getSimpleName()) ||
                            Shooter.class.isAssignableFrom(commonCommand.get(i).getClass())) {
                        Boolean value = commonCommand.get(i).step(secondCommand, firstCommand);
                        i++;
                        if (!value) {
                            commonCommand.get(i).attack(firstCommand.get(indexFirstCommand));
                            i = clearListOfHeroes(commonCommand, firstCommand, indexFirstCommand, i);
                        }
                    } else {
                        commonCommand.get(i).attack(firstCommand.get(indexFirstCommand));
                        i = clearListOfHeroes(commonCommand, firstCommand, indexFirstCommand, i);
                    }
                    summariHPfirstCommand = AdditionFunctions.defineSummaryHPOfCommand(firstCommand);
                }

                if (summariHPfirstCommand < 1 | summariHPsecondCommand < 1) {
                    if (summariHPfirstCommand > summariHPsecondCommand) {
                        System.out.printf("\n____Победила первая команда! Осталось жизней:%d____\n",
                                summariHPfirstCommand);
                    } else {
                        System.out.printf("\n____Победила вторая команда! Осталось жизней:%d____\n",
                                summariHPsecondCommand);
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

    public static void fightWithOneTeamInGrafics(ArrayList<BaseTypeUnit> holyTeam,
            ArrayList<BaseTypeUnit> darkTeam,
            ArrayList<BaseTypeUnit> allTeam) {

        int summariHPholyTeam = AdditionFunctions.defineSummaryHPOfCommand(holyTeam);
        int summariHPdarkTeam = AdditionFunctions.defineSummaryHPOfCommand(darkTeam);

        Boolean flag5 = true;
        while (flag5) {
            View.view();
            iScan.nextLine();

            int indexHolyTeam = defineIndexOfAvailableHero(holyTeam);
            int indexDarkTeam = defineIndexOfAvailableHero(darkTeam);

            for (BaseTypeUnit hero : allTeam) {
                if (holyTeam.contains(hero) && hero.curentHealth() > 0) {
                    if (allTeam.get(allTeam.indexOf(hero)).getClass().getSimpleName().equals(Monk.class.getSimpleName())
                            ||
                            Infantryman.class.isAssignableFrom(allTeam.get(allTeam.indexOf(hero)).getClass())
                            ||
                            Shooter.class.isAssignableFrom(allTeam.get(allTeam.indexOf(hero)).getClass())) {
                        Boolean value = allTeam.get(allTeam.indexOf(hero)).step(holyTeam, darkTeam);
                        if (!value) {
                            allTeam.get(allTeam.indexOf(hero)).attack(darkTeam.get(indexDarkTeam));
                        }
                    } else {
                        allTeam.get(allTeam.indexOf(hero)).attack(darkTeam.get(indexDarkTeam));
                    }
                    summariHPdarkTeam = AdditionFunctions.defineSummaryHPOfCommand(darkTeam);
                } else if (darkTeam.contains(hero) && hero.curentHealth() > 0) {
                    if (allTeam.get(allTeam.indexOf(hero)).getClass().getSimpleName().equals(Monk.class.getSimpleName())
                            ||
                            Infantryman.class.isAssignableFrom(allTeam.get(allTeam.indexOf(hero)).getClass())
                            ||
                            Shooter.class.isAssignableFrom(allTeam.get(allTeam.indexOf(hero)).getClass())) {
                        Boolean value = allTeam.get(allTeam.indexOf(hero)).step(darkTeam, holyTeam);
                        if (!value) {
                            allTeam.get(allTeam.indexOf(hero)).attack(holyTeam.get(indexHolyTeam));
                        }
                    } else {
                        allTeam.get(allTeam.indexOf(hero)).attack(holyTeam.get(indexHolyTeam));
                    }
                    summariHPholyTeam = AdditionFunctions.defineSummaryHPOfCommand(holyTeam);
                } else {
                    continue;
                }

                if (defineAvailableOfCommand(holyTeam) == 0 | defineAvailableOfCommand(darkTeam) == 0) {
                    System.out.println("\n----------------КОНЕЦ ИГРЫ------------------");
                    View.view();
                    if (defineAvailableOfCommand(holyTeam) > defineAvailableOfCommand(darkTeam)) {
                        System.out.printf("\n____Победила первая команда! Осталось жизней:%d____\n",
                                summariHPholyTeam);
                    } else {
                        System.out.printf("\n____Победила вторая команда! Осталось жизней:%d____\n",
                                summariHPdarkTeam);
                    }
                    flag5 = false;
                    System.out.printf("---Общее здоровье Синей команды: %d---\n", summariHPholyTeam);
                    System.out.printf("---Общее здоровье Зеленой команды: %d---\n", summariHPdarkTeam);
                    break;
                } else {
                    flag5 = true;
                }
            }
        }
    }

    public static ArrayList<String> getListOfNames(ArrayList<BaseTypeUnit> command) {
        ArrayList<String> list = new ArrayList<>();
        command.forEach(u -> list.add(u.getName()));
        return list;
    }

    public static int defineSummaryHPOfCommand(ArrayList<BaseTypeUnit> command) {
        int summariHP = 0;
        for (BaseTypeUnit unit : command) {
            if (unit.curentHealth() > 0) {
                summariHP += unit.curentHealth();
            }
        }
        return summariHP;
    }

    public static int defineAvailableOfCommand(ArrayList<BaseTypeUnit> command) {
        int sizeOfCommand = command.size();

        for (BaseTypeUnit unit : command) {
            if (unit.curentHealth() < 1) {
                --sizeOfCommand;
            }
        }
        return sizeOfCommand;
    }

    public static int defineIndexOfAvailableHero(ArrayList<BaseTypeUnit> command) {
        Random rnd = new Random();
        int indexHeroOfCommand = rnd.nextInt(0, command.size());

        Boolean flagHealHeroOfCommand = true;
        while (flagHealHeroOfCommand) {
            if (command.get(indexHeroOfCommand).curentHealth() < 1) {
                indexHeroOfCommand = rnd.nextInt(0, command.size());
            } else {
                flagHealHeroOfCommand = false;
            }
        }
        return indexHeroOfCommand;
    }

    public static int clearListOfHeroes(ArrayList<BaseTypeUnit> commonCommand,
            ArrayList<BaseTypeUnit> enemyCommand,
            int indexHeroEnemyCommand,
            int i) {
        if (!enemyCommand.get(indexHeroEnemyCommand).getAvailability()) {

            Integer indexHero = null;
            for (BaseTypeUnit u : commonCommand) {
                if (u.getName().equals(enemyCommand.get(indexHeroEnemyCommand).getName())) {
                    indexHero = commonCommand.indexOf(u);
                    break;
                }
            }
            enemyCommand.remove(indexHeroEnemyCommand);
            commonCommand.remove((int) indexHero);
            return i;
        } else {
            return ++i;
        }
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Map<String, String> getCoordinatsHeroesOfCommand(ArrayList<BaseTypeUnit> command) {
        Map<String, String> ListCordHeroes = new HashMap<>();
        for (BaseTypeUnit unit : command) {
            ListCordHeroes.put(Arrays.toString(unit.getCoordinates()).replaceAll("[\\[\\]\\ ]", ""), unit.getName());
        }
        return ListCordHeroes;
    }

    public static int[][] getlListEmptyCoordinats(int[] xy, Map<String, String> ListCoordinatesCommons) {
        int[][] listEmptyCordinats = new int[4][2];
        ;
        // ячейка спереди по Y
        int[] newXY = xy.clone();
        newXY[1] = xy[1] + 1;
        String newXYstring = Arrays.toString(newXY).replaceAll("[\\[\\]\\ ]", "");
        if (!ListCoordinatesCommons.containsKey(newXYstring) && newXY[1] != 0 && newXY[1] != 11) {
            listEmptyCordinats[0] = newXY;
        }
        // ячейка справа по X
        newXY = xy.clone();
        newXY[0] = xy[0] + 1;
        newXYstring = Arrays.toString(newXY).replaceAll("[\\[\\]\\ ]", "");
        if (!ListCoordinatesCommons.containsKey(newXYstring) && newXY[0] != 0 && newXY[0] != 11) {
            listEmptyCordinats[1] = newXY;
        }
        // ячейка слева по X
        newXY = xy.clone();
        newXY[0] = xy[0] - 1;
        newXYstring = Arrays.toString(newXY).replaceAll("[\\[\\]\\ ]", "");
        if (!ListCoordinatesCommons.containsKey(newXYstring) && newXY[0] != 0 && newXY[0] != 11) {
            listEmptyCordinats[2] = newXY;
        }
        // ячейка сзади по Y
        newXY = xy.clone();
        newXY[1] = xy[1] - 1;
        newXYstring = Arrays.toString(newXY).replaceAll("[\\[\\]\\ ]", "");
        if (!ListCoordinatesCommons.containsKey(newXYstring) && newXY[1] != 0 && newXY[1] != 11) {
            listEmptyCordinats[3] = newXY;
        }
        return listEmptyCordinats;
    }

    public static int[] defineShortDistance(int[] targetXY, int[][] listEmptyCordinats) {
        int[] nearestCoordinates = new int[0];
        double minDistance = Double.MAX_VALUE;
        double distance;

        for (int[] i : listEmptyCordinats) {
            if (i[0] == 0) {
                continue;
            } else {
                distance = Math.sqrt(Math.pow(i[0] - targetXY[0], 2) + Math.pow(i[1] - targetXY[1], 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestCoordinates = i;
                }
            }
        }
        return nearestCoordinates;
    }
}