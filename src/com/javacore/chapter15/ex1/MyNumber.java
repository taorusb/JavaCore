package com.javacore.chapter15.ex1;

// Продемонстрировать применение простого лямбда-выражения

// Функциональный интерфейс
interface MyNumber {
    double getValue();
}

class LambdaDemo {
    public static void main(String[] args) {
        MyNumber myNum; // объявить ссылку на функциональный интерфейс

        // Здесь лямбда-выражение просто является константным выражением
        // Когда оно присваивается ссылочной переменной myNum, получается
        // экземпляр класса, в котором лямбда-выражение реализует
        // метод getValue() из функционального интерфейса MyNumber
        myNum = () -> 123.45;

        // вызвать метод getValue(), предоставленный
        // рисвоенным ранее лямда-выражением
        System.out.println("Фиксированное значение: " + myNum.getValue());

        // А здесь ипользуется более сложное выражение
        myNum = () -> Math.random() * 100;

        // В следующих строках кода вызывается лямбда-выражение
        // из предыдущей строки кода
        System.out.println("Случайное значение: " + myNum.getValue());
        System.out.println("Еще одно случайное значение: " + myNum.getValue());

        // Лямбда-выражение должно быть совместимым с абстрактным методом,
        // определенным в функциональном интерфейсе. Поэтому
        // следущая строка кода ошибочна:

        // myNum = () -> "123.03" // ОШИБКА!
    }
}


