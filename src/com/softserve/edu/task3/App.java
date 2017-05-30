package com.softserve.edu.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by TDK on 30.05.2017.
 */
public class App {

    public static void main(String[] args) throws IOException {
        TriangleList list = new TriangleList();
        list.fillTriangleList();
        list.sortTriangles();
        list.printTriangles();
    }
}
