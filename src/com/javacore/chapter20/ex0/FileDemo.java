package com.javacore.chapter20.ex0;

import java.io.File;

// Продемонстрировать применение некоторых методов из класса File
public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("JavaCore.iml");
        p("Имя файла " + f1.getName());
        p("Путь:  " + f1.getPath());
        p("Абсолютный путь " + f1.getAbsolutePath());
        p("Родительский каталог " + f1.getParent());
        p(f1.exists() ? "существует" : "не существует");
        p(f1.canWrite() ? "доступен для записи" : "не доступен для записи");
        p(f1.canRead() ? "доступен для чтения" : "не доступен для чтения");
        p(f1.isDirectory() ? "является каталогом" : "не является каталогом");
        p(f1.isFile() ? "является обычным файлом" : "не является обычным файлом");
        p(f1.isAbsolute() ? "является абсолютным" : "не является абсолютным");
        p("Последнее изменение в файле " + f1.lastModified());
        p("Размер " + f1.length() + " байт");
    }
}
