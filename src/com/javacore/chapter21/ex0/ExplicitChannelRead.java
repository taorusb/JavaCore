package com.javacore.chapter21.ex0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

// Использовать канал ввода-вывода для чтения файла.
// Требуется установка JDK, начиная с 7 версии
public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath  = null;

        // сначала получить путь к файлу
        try {
            filepath = Path.of("test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        }

        // затем получить канал к этому файлу в
        // блоке try с ресурсами
        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)){

            // выделить память под буфер
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                // читать данные из файла в буфер
                count = fChan.read(mBuf);

                // прекратить чтение по достижению конца файла
                if (count != -1) {

                    // подготовить буфер к чтению из него данных
                    mBuf.rewind();

                    // читать байты данных из буфера и
                    // выводить их на экран как символы
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
