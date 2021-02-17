package chapter11.ex2;

// Создать поток исполнения, расширив класс Thread
public class NewThread extends Thread {

    NewThread() {
        // создать новый, второй поток исполнения
        super( "Демонстрационный поток");
        System.out.println("Дочерний поток создан: " + this);
        start(); // запустить поток на исполнение
    }

    // точка входа во второй поток исполнения
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерний поток прерван.");
        }
        System.out.println("Дочерний поток завершен.");
    }
}

class ThreadDemo {
    public static void main(String[] args) {
        new NewThread(); // создать новый поток исполнения

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван.");
        }
        System.out.println("Главный поток завершен.");
    }
}
