package com.javacore.chapter22.ex4;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Продемонстрировать применение класса HttpURLConnection
public class HttpURLDemo {
    public static void main(String[] args) throws Exception{
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // вывести метод запроса
        System.out.println("Метод запроса: " + hpCon.getRequestMethod());

        // вывести код ответа
        System.out.println("Код ответа: " + hpCon.getResponseCode());

        // вывести ответное сообщение
        System.out.println("Ответное сообщение: " + hpCon.getResponseMessage());

        // получить список полей и множество
        // ключей из заголовка
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();

        // вывести все ключи и значения из заголовков
        for (String k : hdrField) {
            System.out.println("Ключ: " + k + " Значение: " + hdrMap.get(k));
        }
    }
}
