package com.javacore.chapter15.ex8;

// Пример захвата локальной переменной из объемлюйщей области действия
public interface MyFunc {
    int func(int n);
}

class VarCapture {
    public static void main(String[] args) {
        // Локальная переменная, которая может быть захваченна
        int num = 10;

        MyFunc myLambda = (n) -> {
            // Такое применение переменной num допустимо, поскольку
            // она не видоизменяется
            int v = num + n;

            // Но следующая строка кода недопустима, поскольку в ней
            // предпринемается попытка видоизменить значение переменной num
            //num++;

            // И следующая строка кода приводит к ошибке, поскольку в ней
            // нарушается действительно завершенное состояние переменной num
            // num = 9;
            return v;
        };
    }
}
