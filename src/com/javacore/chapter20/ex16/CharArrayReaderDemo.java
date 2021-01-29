package com.javacore.chapter20.ex16;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

// Продемонстрировать применение класса CharArrayReader
// В этой программе используется оператор try с ресурсами.
// Требуется установка комплекта JDK, начиная с 7 верисии
public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String tmp = "abcdefghijklmnoprstuvwxyz";
        int length = tmp.length();
        char[] c = new char[length];

        tmp.getChars(0, length, c, 0);
        int i;

        try (CharArrayReader input1 = new CharArrayReader(c)){
            System.out.println("input1: ");
            while ((i = input1.read()) != -1) System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }

        try (CharArrayReader input2 = new CharArrayReader(c, 0, 5)){

            System.out.println("input2: ");
            while ((i = input2.read()) != -1) System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }
    }
}
