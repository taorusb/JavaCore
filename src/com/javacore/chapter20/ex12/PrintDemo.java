package com.javacore.chapter20.ex12;

// Продемонстрировать применение метода printf()
public class PrintDemo {
    public static void main(String[] args) {
        System.out.println("Ниже приведенны некоторые числовые значения в разных форматах\n");
        System.out.println("Разные числовые форматы: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();
        System.out.printf("Формат числе с плавающей точкой " +
                "по умолчанию: %f\n", 1234567.123);
        System.out.printf("Формат числе с плавающей точкой " +
                "разделенных запятыми: %,f\n", 1234567.123);
        System.out.printf("Формат отрицательных чисел с " +
                "плавающей точкой по умолчанию: %, f\n", -1234567.123);
        System.out.printf("Формат отрицательных чисел с " +
                "плавающей точкой: %, (f\n", -1234567.123);
        System.out.println();
        System.out.println("Выравнивание положительных и отрицательных числовых значений:\n");
        System.out.printf("% ,.2f\n% ,.2f\n", 1234567.12, -1234567.12);
    }
}
