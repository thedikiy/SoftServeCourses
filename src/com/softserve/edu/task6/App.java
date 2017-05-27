package com.softserve.edu.task6;

import java.math.*;
import java.util.Arrays;

/**
 * Created by TDK on 24.05.2017.
 */
/*6. Счастливые билеты
Счастливые билеты.
Есть 2 способа подсчёта счастливых билетов:
1. Московский — если на автобусном билете напечатано шестизначное число, и
сумма первых трёх цифр равна сумме последних трёх, то этот билет считается
счастливым.
2. Ленинградский, или Питерский — если сумма чётных цифр билета равна сумме
нечётных цифр билета, то билет считается счастливым.
Задача:
Номер билета - шестизначное число. Нужно написать консольное приложение,
которое может посчитать количество счастливых билетов. Для выбора алгоритма
подсчёта читается текстовый файл. Путь к текстовому файлу задаётся в консоли
после запуска программы. Индикаторы
алгоритмов:
1 - слово 'Moskow'
2 - слово 'Piter'
После задания всех необходимых параметров, программа в консоль должна вывести
количество счастливых билетов для указанного способа подсчёта.*/

public class App {
    /**
     * Shows USE help
     */
    public static void appHelp() {
        System.out.println("Lucky Tickets \n" +
                "Use : \n" +
                "Enter file with algorithm ID: App [path] \n");
    }


    public static void main(String[] args) {
        if (args.length == 1) {
            ID id = new FileReader(args[0]).getAlgorithmID();
            switch (id) {
                case MOSKOW:
                    System.out.println(new TicketCounter().count(new Moskow()));
                    break;
                case PITER:
                    System.out.println(new TicketCounter().count(new Piter()));
                    break;
                case UNKNOWN:
                    System.out.println("Wrong file input");
            }
        } else {
            appHelp();
        }
    }
}
