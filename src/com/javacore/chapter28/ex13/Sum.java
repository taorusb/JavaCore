package chapter28.ex13;

// Простой пример применения класса RecursiveTask<V>

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Класс RecursiveTask, используемый для вычисления суммы
// значений элементов в массиве типа double
public class Sum extends RecursiveTask<Double> {

    // Пороговое значение последовательного выполнения
    final int seqThreshold = 500;

    // обрабатываемый массив
    double[] data;

    // определить часть обрабатываемых данных
    int start, end;

    Sum(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }


    // орпеделить сумму значений элементов в массиве типа double
    @Override
    protected Double compute() {
        double sum = 0;

        // Если количество элементов ниже порогового зачения, то выполнить далее обработку последовательно
        if ((end - start) < seqThreshold) {
            // суммировать значения в массиве типа double
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            // В противном случае продолжить разделение данных на меньшие части

            // найти середину
            int middle = (start + end) / 2;

            // запустить новые подзадачи на выполнение, используя разделенные на части данные
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            // запустить кажду задачу путем разветления
            subTaskA.fork();
            subTaskB.fork();

            // ожидать завершения подзадач и накопить результаты
            sum = subTaskA.join() + subTaskB.join();
        }
        // возвратить конечную сумму
        return sum;
    }
}

// Продемонстрировать параллельное выполнение
class RecurTaskDemo {
    public static void main(String[] args) {
        // создать пул задач
        ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[5000];

        // инициализировать массив nums чередующимися положительными и отрицательными значениями
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((i % 2) == 0) ? i : -i;
        }

        Sum task = new Sum(nums, 0, nums.length);

        // Запустить задачи типа ForkJoinTask. Обратите внимание на то,
        // что в данном случае метод invoke() возвращает результат
        double summation = fjp.invoke(task);
        System.out.println("Суммирование " + summation);
    }
}
