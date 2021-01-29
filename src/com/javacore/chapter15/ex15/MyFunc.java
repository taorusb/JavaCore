package com.javacore.chapter15.ex15;

// Продемонстрировать применение ссылки на конструктор
// обобщенного класса


// Теперь функциональный интерфейс MyFunc обобщенный
public interface MyFunc<T> {
    MyClass<T> func(T n);
}

class MyClass<T> {
    private T val;

    MyClass() {}
    MyClass(T v) { val = v;}

    T getVal() { return val; }
}

class ConstructorRefDemo2 {

    public static void main(String[] args) {

        // Создать ссылку на конструктор класса MyClass<T>
        MyFunc<Integer> myClassCons = MyClass<Integer>::new;

        // Создать экземпляр класса MyClass<T>
        // по данной ссылке на конструктор
        MyClass<Integer> mc = myClassCons.func(100);

        // Использовать только что созданный экземпляр класса MyClass<T>
        System.out.println("Значение val в объекте mc равно: " + mc.getVal());
    }
}