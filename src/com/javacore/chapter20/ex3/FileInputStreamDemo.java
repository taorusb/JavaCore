package com.javacore.chapter20.ex3;

import java.io.FileInputStream;
import java.io.IOException;

// Продемонстрировать применение FileInputStreamDemo.
// В этой программе используется оператор try с ресурсами.
// Требуется установка JDK, начиная с верисии 7
public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;

        // Для автоматического закрытия потока ввода
        // используется оператор try с ресурсами
        try (FileInputStream f = new FileInputStream("JavaCore.iml")) {
            System.out.println("Общее количество доступных байтов: " + (size = f.available()));
            int n = size / 40;
            System.out.println("Первые " + n + " байтов, "
            + "прочитанных по очереди из файла методом read()");
            for (int i = 0; i < n; i++) {
                System.out.print((char) f.read());
            }
            System.out.println("\nВсе еще доступно " + f.available());
            System.out.println("Чтение следующих " + n + " байтов по очереди методом read(b[])");
            byte[] b = new  byte[n];
            if (f.read(b) != n)
                System.out.println("Нельзя прочитать " + n + " байтов");
            System.out.println("Пропустить половину оставшихся байтов методом skip()");
            f.skip(size/2);
            System.out.println("\nВсе еще доступно " + f.available());
            System.out.println("Чтение " + n/2 + " байтов размещенных в конце массива");
            if (f.read(b, n/2, n/2) != n/2)
                System.out.println("Нельзя прочитать " + n/2 + " байтов.");
            System.out.println(new String(b, 0, b.length));
            System.out.println("\nВсе еще доступно: " + f.available());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }
    }
}
