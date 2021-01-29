package com.javacore.chapter22.ex1;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// Продемонстрировать оперирование сокетами
public class Whois {
    public static void main(String[] args) throws Exception{
        int c;

        // создать сокетное соединение с
        // веб-сайтом internic.net через порт 43
        Socket s = new Socket("whois.internic.net", 43);

        // получить потоки ввода-вывода
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        // сформировать строку запроса
        String str = (args.length == 0 ? "OraclePressBooks.com" : args[0]) + "\n";

        // преоброзовать строку запроса в байты
        byte[] buf = str.getBytes();

        // послать запрос
        out.write(buf);

        // прочитать ответ и вывести его на экран
        while ((c = in.read()) != -1) {
            System.out.print( (char) c);
        }
        s.close();
    }
}
