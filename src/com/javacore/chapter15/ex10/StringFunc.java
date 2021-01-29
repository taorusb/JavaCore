package com.javacore.chapter15.ex10;

// Продемонстрировать применение ссылка на метод экземпляра

// Функциональный интерфейс для операций с символьными строками
public interface StringFunc {
    String func(String n);
}

// Теперь в этом классе определяется метод экземпляра strReverse()
class MyStringOps {
    String strReverse(String str) {
        String result = "";

        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

class MethodRefDemo2 {
    // В этом методе функциональный интерфейс указывается в качестве
    // типа его первого параметра. Следовательно, ему может быть передан
    // любой экземпляр этого интерфейса, включая и ссылку на метод
    static String stringOp(StringFunc sf, String str) {
        return sf.func(str);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        // Создать объект типа MyStringOps
        MyStringOps strOps = new MyStringOps();

        // А теперь ссылка на метод экземпляра strReverse()
        // передается методу stringOp()
        outStr = stringOp(strOps::strReverse, inStr);

        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
