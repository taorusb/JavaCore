package com.javacore.chapter13.ex18;

public class MyClass {
    int a;
    int b;

    // инициализировать поля а и b по отдельности
    MyClass(int i, int j) {
        a = i;
        b = j;
    }

    // инициализировать поля a и b одним и тем же значением
    MyClass(int i) {
        a = i;
        b = i;
    }

    // присвоить полям а и b нулевое значение по умолчанию
    MyClass( ) {
        a = 0;
        b = 0;
    }
}
