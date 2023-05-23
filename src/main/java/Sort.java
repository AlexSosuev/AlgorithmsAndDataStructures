import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};
        //bubbleSort(array);
        //directSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));
        //System.out.println(find(array, 5));
        System.out.println(binarySearch(array, 5));

    }

    //Сортировка пузырьком
    private static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    finish = false;
                }
            }

        } while (!finish);
    }

    //Сортировка выбором
    private static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                extracted(array, i, minPosition);
            }
        }
    }

    //Сортировка вставками
    private static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    extracted(array, i, j);
                }
            }
        }
    }

    //Обмен элементов массива
    private static void extracted(int[] array, int indexOne, int indexTwo) {
        int tmp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = tmp;
    }

    //Поиск перебором
    private static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //Бинарный поиск
    private static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;
        if (max < min) {
            return -1;
        } else {
            midPoint = (max - min) / 2 + min;
        }
        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        } else {
            if (array[midPoint] > value) {
                return binarySearch(array, value, min, midPoint - 1);
            } else {
                return midPoint;
            }
        }
    }

    //Переопределение метода
    private static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    //Быстрая сортировка (QuickSort)
    private static void sort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    extracted(array, leftPosition, rightPosition);
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            sort(array, startPosition, rightPosition);
        }
    }

    //Пирамидальная сортировка
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; //Инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2; // правый = 2 * rootIndex + 1

        //Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        //Если правый дочений элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        //Если самый большой элемент не корень
        if (largest != rootIndex) {
            extracted(array, rootIndex, largest);
        }
        //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
        heapify(array, heapSize, largest);
    }

    private static void sort(int[] array) {
        //Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        //Один за другим извлекаем элементы из кучи
        for (int i = array.length; i >= 0; i--) {
            //Перемещаем текущий корень в конец
            extracted(array, 0, i);

            //Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
}
