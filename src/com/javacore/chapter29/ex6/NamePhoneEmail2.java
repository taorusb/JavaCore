package com.javacore.chapter29.ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Использовать метод collect() для создания
// списка из List и множества типа Set из потока данных
public class NamePhoneEmail2 {
    String name;
    String phonenum;
    String email;

    public NamePhoneEmail2(String name, String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phonenum;

    public NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}

class StreamDemo5 {
    public static void main(String[] args) {

        // Список имен, номеров и телефонов и
        // адресов электронной почты
        ArrayList<NamePhoneEmail2> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail2("Ларри", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail2("Джеймс", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail2("Мэри", "555-3333", "Mary@HerbSchildt.com"));

        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((a) -> System.out.println(a.name + " " + a.phonenum + " " + a.email));

        // отобразить на новый поток данных
        // только имена и номера телефонов
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        // вызвать метод collect(), чтобы составить
        // список типа List из имен и номеров телефонов
        List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Список имен и номеров телефонов в списке типа List: ");
        for (NamePhone e : npList) {
            System.out.println(e.name + ": " + e.phonenum);
        }

        // получить другое отображение имен и номеров телефонов
        nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));

        // а теперь создать множество типа Set,
        // вызвав метод collect()
        Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("\nИмена и номера телефонов в множестве типа Set");
        for (NamePhone e : npList) {
            System.out.println(e.name + ": " + e.phonenum);
        }
    }
}

