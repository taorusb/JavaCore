package com.javacore.chapter13.ex7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 Копирование файла.
 Чтобы воспользоваться этой программой, укажите
 имя исходного и целевого файлов.
 Например, чтобы скопировать файл FIRST.TXT в файл SECOND.TXT,
 введите в командной строке следующую команду:

 java CopyFile FIRST.TXT SECOND.TXT
 */
public class CopyFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        // сначала убедиться, что указанны имена обоих файлов
        if (args.length != 2) {
            System.out.println("Использование: CopyFile откуда куда");
            return;
        }

        // копировать файл
        try {
            // попытка открыть файлы
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e ) {
                System.out.println("Ошибка закрытия ввода");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия вывода");
            }
        }
    }
}
