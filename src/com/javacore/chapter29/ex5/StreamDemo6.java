package com.javacore.chapter29.ex5;

import java.util.ArrayList;
import java.util.stream.IntStream;

// Отобразить поток данных типа Stream на поток данных IntStream
public class StreamDemo6 {
    public static void main(String[] args) {
        // список значений типа double
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);
        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((a) -> System.out.println(a + " "));
        System.out.println();

        // Отобразить максимально доступный предел
        // каждого значения из списка myList на поток
        // данных типа intStream
        IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a));
        System.out.println("Максимально допустимые пределы ");
        cStrm.forEach((a) -> System.out.print(a + " "));
    }
}
