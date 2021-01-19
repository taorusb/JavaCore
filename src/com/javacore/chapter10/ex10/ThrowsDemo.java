package com.javacore.chapter10.ex10;

//Эта программа написанна верно
public class ThrowsDemo {
    static void throwOne() throws IllegalAccessException{
        System.out.println("В теле метода throwOne().");
        throw new IllegalAccessException("Демонстрация");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Перехваченно исключение: " + e);
        }

    }
}
