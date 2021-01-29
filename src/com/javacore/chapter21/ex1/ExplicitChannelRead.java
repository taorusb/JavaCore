package com.javacore.chapter21.ex1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

// Более компактный способ открытия канала.
// Требуется установка JDK, начиная с 7 версии
public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        // Здесь канал открывается по пути, возвращаемому
        // методом Path.get() в виде объекта типа Path.
        // Переменная filepath больше не нужна
        try (SeekableByteChannel fChan = Files.newByteChannel(Path.of("test.txt"))){

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
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
