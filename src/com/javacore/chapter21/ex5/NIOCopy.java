package com.javacore.chapter21.ex5;

import java.io.IOException;
import java.nio.file.*;

// Скопировать файл средствами системы ввода-вывода NIO
// Требуется установка JDK, начиная с 7 версии
public class NIOCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Применение: откуда и куда копировать");
        }

        try {
            Path source = Path.of(args[0]);
            Path target = Path.of(args[1]);

            // скопировать файл
            Files.copy(source, target);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
