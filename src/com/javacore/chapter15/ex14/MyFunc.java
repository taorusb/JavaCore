package com.javacore.chapter15.ex14;

// Продемонстрировать применение ссылки на конструктор


// В функциональном интерфейсе MyFunc определяется метод,
// возвращающий ссылку на класс MyClass
public interface MyFunc {
    MyClass func(int n);
}

class MyClass {
    private int val;

    MyClass() {}
    MyClass(int v) { val = v;}

    int getVal() { return val; }
}

class ConstructorRefDemo {
    public static void main(String[] args) {

        // Создать ссылку на конструктор класса MyClass.
        // Метод func() из интерфейса MyFunc принимает аргумент,
        // поэтому оператор new обращается к параметризированному
        // конструктору класса MyClass, а не к его конструктору по умолчанию
        MyFunc myClassCons = MyClass::new;

        // Создать экземпляр класса MyClass по ссылке на его конструктор
        MyClass mc = myClassCons.func(100);

        // Использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно: " + mc.getVal());
    }
}