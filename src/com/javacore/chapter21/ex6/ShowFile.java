package com.javacore.chapter21.ex6;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

/*
 Эта программа выводит текстовой файл, используя код
 потокового ввода-вывода на основе системы NIO.
 Требуется установка JDK, начиная с 7 версии

 Чтобы воспользоваться этой программой, укажите имя файла,
 который требуется посмотреть. Например, чтобы посмотреть
 файл TEST.TXT, введите в режиме командной строки
 следующую команду:

 java ShowFile TEST.TXT
 */
public class ShowFile {
    public static void main(String[] args) {
        int i;

        // сначала удостовериться, что указанно имя файла
        if (args.length != 1) {
            System.out.println("Применение: ShowFile имя_файла");
            return;
        }

        // открыть файл и получить связанный с ним поток ввода-вывода
        try (InputStream fin = Files.newInputStream(Path.of(args[0]))){

            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
