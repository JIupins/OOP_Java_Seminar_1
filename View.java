package OOP_Java_Seminar_1;

import java.util.Collections;

import OOP_Java_Seminar_1.Units.BaseTypeUnit;

public class View {
    private static int step = 1;
    private static final int[] l = { 0 };
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b")))
            + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e")))
            + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h")))
            + formatDiv("-i");

    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0)
            System.out.printf("%" + dif + "s", " \t");
        else
            System.out.print(" \t");
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getChar(int x, int y) {
        String out = "| ";
        for (BaseTypeUnit human : Game.allTeam) {
            int xx = human.getCoordinates()[0];
            int yy = human.getCoordinates()[1];
            // char hn =human.getName().charAt(0);
            if (xx == x && yy == y) {
                if (human.curentHealth() < 1) {
                    out = "|" + (AnsiColors.ANSI_RED + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (Game.darkTeam.contains(human))
                    out = "|" + (AnsiColors.ANSI_GREEN + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                if (Game.holyTeam.contains(human))
                    out = "|" + (AnsiColors.ANSI_BLUE + human.getName().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }

    public static void view() {
        if (step == 1) {
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Game.allTeam.forEach(v -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0] * 2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Green side");
        // for (int i = 0; i < l[0]-9; i++)
        System.out.print("   ".repeat(l[0]-4));
        System.out.println(" \tBlue side");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.printf("N->%s HP->%d",Game.darkTeam.get(0).getName(),Game.darkTeam.get(0).curentHealth());
        tabSetter(Game.holyTeam.get(0).toString().length(), l[0]);
        System.out.printf("N->%s HP->%d\n",Game.holyTeam.get(0).getName(),Game.holyTeam.get(0).curentHealth());
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            if (Game.darkTeam.size() >= i) {
                System.out.printf("N->%s HP->%d",Game.darkTeam.get(i-1).getName(),Game.darkTeam.get(i-1).curentHealth());
                tabSetter(Game.darkTeam.get(i - 1).toString().length(), l[0]);
            } else {
                System.out.print("-----");
                tabSetter(Game.darkTeam.get(0).toString().length(), l[0]);
            }

            if (Game.holyTeam.size() >= i) {
                System.out.printf("N->%s HP->%d\n",Game.holyTeam.get(i-1).getName(),Game.holyTeam.get(i-1).curentHealth());
            } else {
                System.out.print("-----\n");
            }
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        if (Game.darkTeam.size() > 9) {
            System.out.printf("N->%s HP->%d",Game.darkTeam.get(9).getName(),Game.darkTeam.get(9).curentHealth());
            tabSetter(Game.darkTeam.get(9).toString().length(), l[0]);
        } else {
            System.out.print("-----");
            tabSetter(Game.darkTeam.get(0).toString().length(), l[0]);
        }
        if (Game.holyTeam.size() > 9) {
            System.out.printf("N->%s HP->%d\n",Game.holyTeam.get(9).getName(),Game.holyTeam.get(9).curentHealth());
        } else {
            System.out.print("-----\n");
        }
        System.out.println(bottom10);
    }
}