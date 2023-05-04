package OOP_Java_Seminar_1;

import java.util.ArrayList;
import java.util.Scanner;

import OOP_Java_Seminar_1.Units.*;

public class Game {
    static ArrayList<BaseTypeUnit> firstCommand = new ArrayList<>();
    static ArrayList<BaseTypeUnit> secondCommand = new ArrayList<>();
    static ArrayList<BaseTypeUnit> commonCommand = new ArrayList<>();

    static Scanner iScan = new Scanner(System.in);

    public static void main(String[] args) {
        gameProcess();
    }

    public static void gameProcess() {
        boolean flag1 = true; // активнность игры
        boolean flag3 = false; // индикатор существования команд

        while (flag1) {
            boolean flag2 = true; // активнность меню информации о командах

            System.out.println("\nВыберите операцию:" +
                    "\n1 - Создать команды" +
                    "\n2 - Информация о командах" +
                    "\n3 - Начать бой (команда против команды)" +
                    "\n4 - Начать бой (первым ходит более инициативный)" +
                    "\n0 - Выйти из игры\n");

            System.out.print("\nВведите символ операции: ");
            int num1 = iScan.nextInt();

            switch (num1) {
                case 1:
                    if (!flag3) {
                        firstCommand = AdditionFunctions.createCommand();
                        secondCommand = AdditionFunctions.createCommand();

                        commonCommand.addAll(firstCommand);
                        commonCommand.addAll(secondCommand);

                        flag3 = true;
                    } else {
                        System.out.println("\nКоманды уже созданы!");
                    }
                    break;

                case 2:
                    if (flag3) {
                        while (flag2) {
                            System.out.println("\nО какой команде вы хотите получить информацию: " +
                                    "\n1 - Первая команда" +
                                    "\n2 - Вторая команда" +
                                    "\n3 - Обе команды игры" +
                                    "\n4 - Список персонажей общей команды" +
                                    "\n0 - Выйти в предыдущее меню");
                            System.out.print("\nВведите символ операции: ");
                            int num2 = iScan.nextInt();

                            switch (num2) {
                                case 1:
                                    firstCommand.forEach(unit -> System.out.println(unit.getInfo()));
                                    break;

                                case 2:
                                    secondCommand.forEach(unit -> System.out.println(unit.getInfo()));
                                    break;

                                case 3:
                                    firstCommand.forEach(unit -> System.out.println(unit.getInfo()));
                                    secondCommand.forEach(unit -> System.out.println(unit.getInfo()));
                                    break;

                                case 4:
                                    commonCommand.sort(BaseTypeUnit::compareTo);
                                    ;
                                    System.out.println();
                                    commonCommand.forEach(u -> System.out.printf(u.toString() + ", "));
                                    System.out.println();
                                    break;

                                case 0:
                                    flag2 = false;
                                    break;

                                default:
                                    System.out.println("\nКоманда выбрана не верно. Повторите выбор!");
                                    flag2 = false;
                                    break;
                            }
                        }
                        break;

                    } else {
                        System.out.println("Команды не созданы!");
                        flag2 = false;
                    }
                    break;

                case 3:
                    if (flag3) {
                        AdditionFunctions.fightTeamToTeam(firstCommand, secondCommand);
                    } else {
                        System.out.println("Команды не созданы!");
                    }
                    break;

                case 4:
                    if (flag3) {
                        AdditionFunctions.fightWithOneTeam(firstCommand, secondCommand, commonCommand);
                    } else {
                        System.out.println("Команды не созданы!");
                    }
                    break;

                case 0:
                    flag1 = false;
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nКоманда выбрана не верно. Повторите выбор!");
                    break;
            }
        }
    }
}