package com.javacore.chapter21.ex8;

import javax.naming.directory.BasicAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

// Получить сведения о пути к файлу и самом файле
// Требуется установка JDK, начиная с 7 версии
public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Path.of("test.txt");

        System.out.println("Имя файла: " + filepath.getName(1));
        System.out.println("Путь к файлу: " + filepath);
        System.out.println("Абсолютный путь: " + filepath.toAbsolutePath());

        System.out.println("Родительский каталог: " + filepath.getParent());
        if (Files.exists(filepath)) System.out.println("Файл существует");
        else System.out.println("Файл не существует");

        try {
            if (Files.isHidden(filepath)) System.out.println("Файл скрыт");
            else System.out.println("Файл не скрыт");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

        if (Files.isWritable(filepath)) System.out.println("Файл доступен для записи");
        if (Files.isReadable(filepath)) System.out.println("Файл доступен для чтения");

        try {
            BasicFileAttributes attribs =
                    Files.readAttributes(filepath, BasicFileAttributes.class);
            if (attribs.isDirectory()) System.out.println("Это каталог");
            else System.out.println("Это не каталог");

            if (attribs.isRegularFile()) System.out.println("Это обычный файл");
            else System.out.println("Это не обычный файл");

            if (attribs.isSymbolicLink()) System.out.println("Это символьная ссылка");
            else System.out.println("Это не символьная ссылка");

            System.out.println("Время последней модификации файла: " + attribs.lastModifiedTime());
            System.out.println("Размер файла: " + attribs.size());
        } catch (Exception e) {
            System.out.println("Ошибка чтения атрибутов: " + e);
        }
    }
}
