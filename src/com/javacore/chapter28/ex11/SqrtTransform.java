package chapter28.ex11;

// Простой пример реализации стратегии
// "разделяй и влавствуй". В данном примере применяется класс RecursiveAction

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// Класс ForkJoinTask преобразует (через класс RecursiveAction) значения
// элементов массива типа double в их квадратные корни
public class SqrtTransform extends RecursiveAction {
    // В данном примере пороговое значение произвольно устанавливается
    // равным 1000. В реальном коде его оптимальное значение может быть определено
    // в результате профилирования исполняющей системы или экперементально
    final int seqThreshold = 1000;

    // обрабатываемый массив
    double[] data;

    // определить часть обрабатываемых данных
    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    @Override
    protected void compute() {

        // елси количество элементов меньше порогового заначения, выполнить дальнейшую обработку
        // последовательно
        if ((end - start) < seqThreshold) {
            // преобразовать значения каждого элемента массива в его квадратный корень
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            // в противном случае продолжить разделение данных на меньшие части

            // найти середину
            int middle = (start + end) / 2;

            // запустить новые подзадачи на выполнение, используя разделенные на части данные
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}

// продемонстрировать паралельное выполнение
class ForkJoinDemo {
    public static void main(String[] args) {
        // создать пул задач
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[100000];

        // присвоить некоторые значения
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        System.out.println("Часть исходной последовательности: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        // запустить главную задачу типа ForkJoinTask на выполнение
        fjp.invoke(task);

        System.out.println("Часть преобразованной последовательности "
        + "(с точностью до четырех знаков после десятичной точки): ");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}