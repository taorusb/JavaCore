package com.javacore.chapter10.ex13;

//Продемонстрировать цепочки исключений
public class ChainExcDemo {
    static void demoproc() {

        //создать исключение
        NullPointerException e = new NullPointerException("верхний уровень");
        //добавить причину исключения
        e.initCause(new ArithmeticException("причина"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            //Вывести исключение верхнего уровня
            System.out.println("Перехваченно исключение: " + e);

            //вывести исключение, послужившее причиной
            //для исключение верхнего уровня
            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
