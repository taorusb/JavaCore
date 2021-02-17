package chapter28.ex12;

// Простой пример программы, позволяющей поэксперементировать с эффектом от изменения
// порового значения и уровня параллелизма выполнения задач к классе ForkJoinTask

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// Класс ForkJoinTask преобразует (через класс RecursiveAction)
// элементы массива типа double
public class SqrtTransform extends RecursiveAction {

    // порог последовательного выполения, устанавливаемый конструктором
    int seqThreshold;

    // обрабатываемый массив
    double[] data;

    // определить часть обрабатываемых данных
    int start, end;

    SqrtTransform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }

    // этот метод выполняет паралельные вычисления
    @Override
    protected void compute() {

        // елси количество элементов меньше порогового заначения, выполнить дальнейшую обработку
        // последовательно
        if ((end - start) < seqThreshold) {
            // в следующем фрагменте кода элементу по четному индексу присваивается квадратный корень
            // его первоначального значения, а элементу по нечетному индексу - кубический корень его
            // первоначального значения. Этот код предназначен только для потребления времени ЦП, чтобы
            // сделать нагляднее эффект от паралельного выполнения
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            // в противном случае продолжить разделение данных на меньшие части

            // найти середину
            int middle = (start + end) / 2;

            // запустить новые подзадачи на выполнение, используя разделенные на части данные
            invokeAll(new SqrtTransform(data, start, middle, seqThreshold),
                    new SqrtTransform(data, middle, end, seqThreshold));
        }
    }
}

// продемонстрировать паралельное выполнение
class ForkJoinDemo {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        if (args.length != 2) {
            System.out.println("Использование: FJExperiment параллелизм порог");
            return;
        }
        pLevel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        // эти переменные используются для измерения времени выполнения задачи
        long beginT, entT;

        // создать пул задач. Обратите внимание на установку уровня параллелизма
        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[100000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        System.out.println("Часть исходной последовательности: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length, threshold);

        // начать измерение времени выполнения задачи
        beginT = System.nanoTime();

        // запустить главную задачу типа ForkJoinTask на выполнение
        fjp.invoke(task);

        // завершить измерение времени выполнения задачи
        entT = System.nanoTime();

        System.out.println("Уровень параллизма " + pLevel);
        System.out.println("Порог последовательной обработки " + threshold);
        System.out.println("Истекшее время: " + (entT - beginT) + " нс");
        System.out.println();
    }
}