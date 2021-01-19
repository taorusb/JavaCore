package com.javacore.chapter10.ex7;

//Операторы try неявно могут быть неявно вложенны в вызовы методов
public class MathNestTry {
    static void nesttry(int a) {
        try { //Вложенный блок оператора try
        /*
          Если указан один аргумент командной строки,
          то исключение в связи с делением на нуль
          будет сгенерированно в следующем коде.
       */
            if (a == 1) a = a / (a - a); //деление на нуль.
                /*
                Если указанны два аргумента командной строки,
                то генерируется исключение в связи с выходом
                за пределы массива.
                 */
            if (a == 2) {
                int[] c = {1};
                c[42] = 99; //Здесь генерируется исключение в связи выходом за пределы массива
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс за пределы массива: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            int a = args.length;
            /*
            Если не указанны аргументы командной строки,
            в следующем операторе будет сгенерированно
            исключение в связи с делением на нуль.
             */
            int b = 42 / a;
            System.out.println("a " + a);
            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Деление на нуль: " + e);
        }
    }
}