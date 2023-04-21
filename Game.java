package OOP_Java_Seminar_1;
/* Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определите 8 полей данных (здоровье, сила итд), 3-4 поля поведения (методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя. */

import OOP_Java_Seminar_1.Units.*;

public class Game {
    public static void main(String[] args) {

        // Маги
        Monk monk = new Monk("Этлау");
        Witch witch = new Witch("Кэр");

        // Стрелки
        Sniper sniper = new Sniper("Роланд");
        Arbalester arbalester = new Arbalester("Неясыть");

        // Пехота
        Barbarian barbarian = new Barbarian("Конан");
        Assassin assasin = new Assassin("Ронин");
        Knight knight = new Knight("Боромир");

        System.out.println(monk.toString().toUpperCase());
        monk.getInfoType();

        System.out.println(witch.toString().toUpperCase());
        witch.getInfoType();

        System.out.println(sniper.toString().toUpperCase());
        sniper.getInfoType();

        System.out.println(arbalester.toString().toUpperCase());
        arbalester.getInfoType();

        System.out.println(barbarian.toString().toUpperCase());
        barbarian.getInfoType();

        System.out.println(assasin.toString().toUpperCase());
        assasin.getInfoType();

        System.out.println(knight.toString().toUpperCase());
        knight.getInfoType();
    }
}