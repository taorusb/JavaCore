package com.javacore.chapter10.ex8;

//Продемонстрировать применение оператора throw
public class ThrowDemo {
    static void demoproc() {
        try {
            throw new NullPointerException("Демонстрация");
        } catch (NullPointerException e) {
            System.out.println("Исключение перехваченно в теле метода demoproc().");
            throw e; //Повторно сгенерированное исключение
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Повторный перехват: " + e);
        }
    }
}
