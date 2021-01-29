package com.javacore.chapter29.ex0;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

// Продемонстрировать несколько потоковых оперций
public class StreamDemo {
    public static void main(String[] args) {
        // создать списочный массив значений типа Integer
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);

        // получить поток элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        // получить минимальное и максимальное значения
        // вызвав методы min() и max(), isPresent() и get()
        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        if (minVal.isPresent())
            System.out.println("Минимальное значение: " + minVal.get());

        // непременно получить новый поток данных,
        // поскольку предыдущий вызов метода min()
        // стал окоченной операцией, употребившей поток данных
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if (maxVal.isPresent())
            System.out.println("Максимальное значение: " + maxVal.get());

        // отсортировать поток данных, вызвав метод sorted()
        Stream<Integer> sortedSteam = myList.stream().sorted();

        // отобразить отсортированный поток данных,
        // вызвав метод forEach()
        sortedSteam.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // вывести только нечетные целочисленные значения,
        // вызвав метод filter()
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.println("Нечетные значения: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // вывести только те нечетные целочисленные
        // значения, которые больше 5. Обратите внимание
        // на конвейеризацию обеих оперций фильтрации
        oddVals = myList.stream().filter((n) -> (n % 2) == 1).filter((n) -> n > 5);
        System.out.println("Нечетные значения больше 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
