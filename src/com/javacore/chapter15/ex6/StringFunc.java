package com.javacore.chapter15.ex6;

// Передать лямбда-выражение в качестве аргумента методу
public interface StringFunc {
    String func(String n);
}

class LambdaAsArgumentDemo {

    // Превый параметр этого метода имеет тип функционального
    // интерфейса. Следовательно, ему можно передать ссылку на
    // любой экземпляр этого интерфейса, включая экземпляр,
    // создаваемый в лямбда-выражении. А второй параметр
    // обозначает обрабатываемую символьную строку
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String intStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Это исходная строка: " + intStr);

        // Ниже приведенно простое лямбда-выражение, преобразуещее
        // в верхний регистр букв все символы исходной строки,
        // передаваемый методу stringOp()
        outStr = stringOp((str) -> {
            String result = "";
            int i;

            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ')
                result += str.charAt(i);
            }
            return result;
        }, intStr);
        System.out.println("Эта строка с удаленными пробелами: " + outStr);

        // Конечно, можно передать и экземпляр интерфейса StringFunc
        // созданный в предыдущем лямбда-выражении. Например, после
        // следующего объявления ссылка reverse делается на экземляр
        // интерфейса StringFunc
        StringFunc reverse = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0 ; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        // А теперь ссылку reverse можно передать в качестве первого
        // параметра методу stringOp()
        // since it refers to a StringFunc object.
        System.out.println("Это обращенная строка: " + stringOp(reverse, intStr));
    }
}
