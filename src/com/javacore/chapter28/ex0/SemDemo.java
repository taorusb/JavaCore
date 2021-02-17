package chapter28.ex0;

import java.util.concurrent.Semaphore;

// Простой пример применения семафора
public class SemDemo {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);
        new Thread(new IncThread(sem, "A")).start();
        new Thread(new DecThread(sem, "B")).start();
        
    }
}

// Общий ресурс
class Shared {
    static int count = 0;
}

// Поток исполнения, увеличивающий значение счетчика на еденицу
class IncThread implements Runnable {

    String name;
    Semaphore sem;
    
    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }
    
    @Override
    public void run() {

        System.out.println("Запуск потока: " + name);
        try {
            // сначала получить резрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешения");
            // а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                // разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

// Поток исполнение, уменьшающий значение счетчика на еденицу
class DecThread implements Runnable {

    Semaphore sem;
    String name;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }

    @Override
    public void run() {

        System.out.println("Запуск потока " + name);

        try {
            // сначала получить резрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешения");
            // а теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                // разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}
