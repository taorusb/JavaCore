package com.javacore.chapter10.ex9;

//Эта программа содержит ошибку, и поэтому она не подлежит компиляции
public class ThrowsDemo {
    static void throwOne() {
        System.out.println("В теле метода throwOne().");
//        throw new IllegalAccessException("Демонстрация");
    }

    public static void main(String[] args) {
        throwOne();
    }
}
