package chapter28.ex10;

import java.util.concurrent.atomic.AtomicInteger;

// Простой пример выполнения атомарных операций
public class AtomicDemo {
    public static void main(String[] args) {

        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
    }
}

class Shared {
    static AtomicInteger ai = new AtomicInteger();
}

// Поток исполнения, в котором инкрементируется значение счетчика
class AtomThread implements Runnable {

    String name;

    AtomThread(String n) {
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Поток " + name + " получено " + Shared.ai.getAndSet(i));
        }
    }
}