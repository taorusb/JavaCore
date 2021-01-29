package com.javacore.chapter21.ex10;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Вывести только те файлы из каталога, которые доступны для записи
public class DirList {
    public static void main(String[] args) {
        String dirname = "\\JavaCore";

        // создать фильтр, возвращающий логическое
        // значение true только в отношении доступных
        // для записи файлов
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                if (Files.isWritable(entry)) return true;
                return false;
            }
        };

        // получить и использовать поток ввода из каталога
        // только доступных для записи файлов
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname))) {
            for (Path entry : dirstrm) {
                BasicFileAttributes attribs =
                        Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory()) System.out.print("<DIR> ");
                else System.out.print("         ");
                System.out.println(entry.getName(1));
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " не является каталогом.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
