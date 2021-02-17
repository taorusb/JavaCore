package chapter28.ex4;

import java.util.concurrent.Exchanger;

// Применение класса Exchanger
public class ExgrDemo {
    public static void main(String[] args) {

        Exchanger<String> exgr = new Exchanger<>();

        new Thread(new UseString(exgr)).start();
        new Thread(new MakeString(exgr)).start();
    }
}

// Поток типа Thread, формирующий символьную строку
class MakeString implements Runnable {

    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> c) {
        ex = c;
        str = new String();
    }

    @Override
    public void run() {

        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            // заполнить буфер
            for (int j = 0; j < 5; j++) {
                str += (char) ch++;
            }
            try {
                // обменять заполненный буфер на пустой
                str = ex.exchange(str);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}

// Поток типа Thread, использующий символьную строку
class UseString implements Runnable {

    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> c) {
        ex = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                // обменять пустой буфер на заполенный
                str = ex.exchange(new String());
                System.out.println("Получено: " + str);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}