package com.javacore.chapter15.ex16;

// Реализовать простую фабрику классов, используя ссылку на конструктор
public interface MyFunc<R, T> {
    R func(T n);
}

// Простой обобщенный класс
class MyClass<T> {
    private T val;

    // Конструктор по умолчанию.
    // Этот конструктор в данной программе НЕ ипользуется
    MyClass() {}

    // Конструктор, принимающий один параметр
    MyClass(T v) { val = v;}

    T getVal() { return val; }
}

// Простой необобщенный класс
class MyClass2 {
    String str;

    // Конструктор принимающий один аргумент
    MyClass2(String s) { str = s; }

    // Конструктор по умолчанию.
    // Этот конструктор в данной программе НЕ ипользуется
    MyClass2() {}

    String getVal() { return str; }
}

class ConstructorRefDemo3 {

    // Фабричный метод для объектов разных классов.
    // У каждого класса должен быть свой конструктор,
    // принимающий один параметр типа Т. А параметр R
    // обозначает тип создаваемого объекта
    static <R, T> R myClassFactory(MyFunc<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {

        // Создать ссылку на конструктор класса MyClass.
        // В данном случае оператор new обращается к конструктору,
        // принимающему аргумент
        MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;

        // создать экземпляр типа класса MyClass, используя фабричный метод
        MyClass<Double> mc = myClassFactory(myClassCons, 100.1);

        // использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mc равно: " + mc.getVal());

        // А теперь создать экземпляр другого класса,
        // используя метод myClassFactory()
        MyFunc<MyClass2, String> myClassCons2 = MyClass2::new;

        // Создать экземпляр класса MyClass2, используя фабричный метод
        MyClass2 mc2 = myClassFactory(myClassCons2, "Лямбда");

        // Использовать только что созданный экземпляр класса MyClass
        System.out.println("Значение str в объекте mc2 равно: " + mc2.getVal());
    }
}
