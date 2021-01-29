package com.javacore.chapter29.ex3;

import java.util.ArrayList;
import java.util.stream.Stream;

// Отобразить один поток данных на другой
public class StreamDemo4 {
    public static void main(String[] args) {
        // Список числовых значений типа dobule
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        // Отобразить квадратные корни элементов из
        // списка myList на новый поток данных
        Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a));

        // получить произведение квадратных корней
        double productOfSqrtRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);
        System.out.println("Произведение квадратных корней равно " + productOfSqrtRoots);
    }
}
