package com.softserve.edu.task7;

/**
 * Created by TDK on 29.05.2017.
 */
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
            try {
                process(Integer.parseInt(args[0]));
            }catch (NumberFormatException e){
                System.out.println("Value must be integer...");
            }
        } else {
            appHelp();
        }
    }

    public static void process(int value){
        int res = 0;
        for (int j = 1; res < value; j++) {
            res = (int) Math.pow(j, 2);
            System.out.println(res);
        }
    }
}
