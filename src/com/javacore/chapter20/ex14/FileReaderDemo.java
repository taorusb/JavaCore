package com.javacore.chapter20.ex14;

import java.io.FileReader;
import java.io.IOException;

// Продемонстрировать применение класса FileReader
// В этой программе используется оператор try с ресурсами.
// Требуется установка комплекта JDK, начиная с 7 верисии
public class FileReaderDemo {
    public static void main(String[] args) {

        try (FileReader fr =
                     new FileReader("src\\com\\javacore\\chapter20\\ex14\\FileReaderDemo.java")) {
            int c;

            // прочитать и вывести содержимое файла
            while ((c = fr.read()) != -1) System.out.print((char) c);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }
    }
}
