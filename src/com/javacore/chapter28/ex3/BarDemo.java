package chapter28.ex3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Продемонстрировать применение класса CyclicBarrier
public class BarDemo {
    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new Thread(new MyThread(cb, "A")).start();
        new Thread(new MyThread(cb, "B")).start();
        new Thread(new MyThread(cb, "C")).start();

    }
}

// Поток исполнения, использующий барьер типа CyclicBarrier
class MyThread implements Runnable {

    CyclicBarrier cbar;
    String name;

    MyThread(CyclicBarrier c, String s) {
        cbar = c;
        name = s;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException exc) {
            System.out.println(exc);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

// Объект этого класса вызывается по достижению барьера типа CyclicBarrier
class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Барьер достигнут!");
    }
}
