package com.javacore.chapter21.ex2;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

// Использовать сопоставление для чтения данных из файла.
// Требуется установка JDK, начиная с 7 версии
public class MappedChannelRead {
    public static void main(String[] args) {

        // получить доступ к файлу в блоке оператора try с ресурсами
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Path.of("test.txt"))){

            // получить размер файла
            long fSize = fChan.size();

            // а теперь сопоставить файл с буфером
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            // читать файлы из буфера и выводить их на экран
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
