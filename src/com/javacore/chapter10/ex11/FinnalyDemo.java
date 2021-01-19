package com.javacore.chapter10.ex11;

//Продемонстрировать применение оператора finally
public class FinnalyDemo {
    //Сгенерировать исключение в методе
    static void procA() {
        try {
            System.out.println("В теле метода procA()");
            throw new RuntimeException("Демонстрация");
        } finally {
            System.out.println("Блок оператора finally в методе procA()");
        }
    }
    static void procB() {
        try {
            System.out.println("В теле метода procB()");
            return;
        } finally {
            System.out.println("Блок оператора finally в методе procB()");
        }
    }
    //Выполнить блок try, как обычно
    static void procC() {
        try {
            System.out.println("В теле метода procC()");
        } finally {
            System.out.println("Блок оператора finally в методе procC()");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Исключение перехваченно");
        }
        procB();
        procC();
    }
}
