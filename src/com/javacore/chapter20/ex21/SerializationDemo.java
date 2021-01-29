package com.javacore.chapter20.ex21;

import java.io.*;

// Продемонстрировать применение сериализации и десириализации
// В этой программе используется оператор try с ресурсами.
// Требуется установка комплекта JDK, начиная с 7 верисии
public class SerializationDemo {
    public static void main(String[] args) {
        // произвести сериализацию объекта

        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial", true))){
            MyClass object1 = new MyClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + object1);
            objOStrm.writeObject(object1);

        } catch (IOException e) {
            System.out.println("Исключение при сериализации: " + e);
        }
        // произвести десериализацию объекта
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"))){
            MyClass object2 = (MyClass) objIStrm.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println("Исключение при десериализации: " + e);
        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}
