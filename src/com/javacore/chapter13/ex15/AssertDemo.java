package com.javacore.chapter13.ex15;

// Неудачное применение оператора assert!!!
public class AssertDemo {
    // получить генератор случайных чисел
    static int val = 3;

    // возвратить целочисленное значение
    static int getnum() {
        return val--;
    }

    public static void main(String[] args) {
        int n = 0;

        for (int i = 0; i < 10; i++) {

            assert (n = getnum()) > 0; // Неудачная идея!

            System.out.println("n равно " + n);
        }
    }
}
