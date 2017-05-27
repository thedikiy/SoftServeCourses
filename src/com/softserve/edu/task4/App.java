package com.softserve.edu.task4;

/**
 * Created by TDK on 24.05.2017.
 */
/*
    4. Файловый парсер

    Нужно написать программу, которая будет иметь два режима:

    1. Считать количество вхождений строки в текстовом файле.

    2. Делать замену строки на другую в указанном файле

    Программа должна принимать аргументы на вход при запуске:

    1. <путь к файлу> <строка для подсчёта>

    2. <путь к файлу> <строка для поиска> <строка для замены>
 */
public class App {
    /**
     * Shows USE help
     */

    public static void appHelp() {
        System.out.println("FILE PARSER \n" +
                "Use : \n" +
                "Count string entries: App [path] [string] \n" +
                "Swap string: App [path] [findString] [replaceString]");
    }

    public static void main(String[] args) {
        Parser parser = null;
        if (args.length > 1) {
            parser = new FileParser(args[0]);
        }
        switch (args.length) {
            case 2:
                parser.countEntries(args[1]);
                break;
            case 3:
                parser.swapString(args[1], args[2]);
                break;
            default:
                appHelp();
        }
    }
}
