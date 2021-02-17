package chapter28.ex6;

import java.util.concurrent.Phaser;

// Расширить класс Phaser и переопределить метод onAdvance() таким
// образом, чтобы было выполнено только определенное количество фаз
public class MyPhaser extends Phaser {

    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    // переопределить метод onAdvance(), чтобы выполнить только опеределенное количество фаз

    @Override
    protected boolean onAdvance(int p, int regParties) {
        // следующий вызов метода println() требуется только для целей иллюстрации.
        // Как правило, метод onAdvance() не отображает выводимые данные
        System.out.println("Фаза " + p + " завершена.\n");

        // возвратить логическое значение true, если все фазы завершенны
        if (p == numPhases || regParties == 0) return true;

        // в противном случае возвратить логическое значение false
        return false;
    }
}

class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phsr = new MyPhaser(1, 4);
        System.out.println("Запуск потоков\n");

        new Thread(new MyThread(phsr, "A")).start();
        new Thread(new MyThread(phsr, "B")).start();
        new Thread(new MyThread(phsr, "C")).start();
    }
}

// Поток исполнения, применяющий синхронизатор фаз типа Phaser
class MyThread implements Runnable {

    Phaser phsr;
    String name;

    MyThread(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
    }

    @Override
    public void run() {

        while (!phsr.isTerminated()) {
            System.out.println("Поток " + name + " начинает фазу " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();

            // небольшая пауза, чтобы не нарушить порядок вывода.
            // это сделано только для целей демонстрации, но
            // не совсем обязательно для правильного функционирования синхронизатора фаз
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
