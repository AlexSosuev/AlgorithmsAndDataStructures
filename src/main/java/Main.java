import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N. Согласно свойствам линейной сложности,
// количество итераций цикла будет линейно изменяться относительно изменения размера N.
//        int n = 100;
//        int result = 0;
//        for (int i = 0; i <= n; i++) {
//            result += i;
//        }
//        System.out.println(result);
        List<Integer> availableDivinder = findSimpleNumbers(100);
        for (Integer integer : availableDivinder) {
            System.out.print(integer + " ");
        }

        System.out.println("\n" + task_3(4, 4));
        System.out.println(combinationCount(4, 4));
    }

    //Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N.
//В алгоритме будет использоваться вложенный for, что явно говорит о квадратичной сложности, на этом
//стоит акцентировать внимание
    public static List<Integer> findSimpleNumbers(int n) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            boolean bool = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) {
                temp.add(i);
            }
        }
        return temp;
    }

    //Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество) для количества кубиков K с
    // количеством граней N. У вас есть 2 варианта на выбор – количество кубиков может быть строго ограничено (4 кубика,
    // например), либо их количество будет динамическим. Выбор за вами.  Если вы реализуете простой вариант, обращает
    // внимание, что данное решение имеет сложность O(n4), но если количество кубиков сделать переменной, то она
    // трансформируется в O(nk), что будет представлять собой экспоненциальную сложность. Для второго решения очевидно,
    // что его сложность O(nk) с самого начала.
    public static int task_3(int facets, int countKub) {
        return (int) Math.pow(facets, countKub);
    }

    public static int combinationCount(int count, int faces) {
        if (count > 0) {
            return recursiveCounter(1, count, faces);
        } else {
            return 0;
        }
    }

    private static int recursiveCounter(int depth, int maxDepth, int faces) {
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            if (depth == maxDepth) {
                count++;
            } else {
                count += recursiveCounter(depth + 1, maxDepth, faces);
            }
        }
        return count;
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }


}