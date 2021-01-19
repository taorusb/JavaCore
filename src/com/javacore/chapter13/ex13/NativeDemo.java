package com.javacore.chapter13.ex13;

// Простой пример применения платформенно-ориентированного метода
public class NativeDemo {
    int i;

    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();
        ob.i = 10;
        System.out.println("Содержимое переменной ob.i перед вызвом " +
                "платформенно-ориентированного метода: " + ob.i);
        ob.test(); // вызвать платформенно-ориентированный метод
        System.out.println("Содержимое переменной ob.i после вызова" +
                "платформенно-ориентированного метода: " + ob.i);
    }

    // объявить платформенно-ориентированный метод
    public native void test();

    // загрузить библиотеку DLL, содержащую статический метод
    static {
        System.load("NativeDemo");
    }
}
