package com.javacore.chapter10.ex14;

//Продемонстрировать многократный перехват
public class MultiCatch {
    public static void main(String[] args) {
        int a = 10, b = 0;
        int[] vals = {1, 2 , 3};

        try {
            int result = a / b; //сгенерировать исключение
                                //типа ArithmeticException
            //vals[10] = 19;    //сгенерировать исключение
                                //типа ArrayIndexOfBoundsException
            //В этом операторе catch мы перехватываем оба исключения
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Исключение перехваченно: " + e);
        }
        System.out.println("После многократного перехвата.");
    }
}
