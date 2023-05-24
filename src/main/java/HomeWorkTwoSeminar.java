import java.util.Arrays;

public class HomeWorkTwoSeminar {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        //Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        //Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            //Перемещаем текущий корень в конец
            extracted(array, 0, i);

            //Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
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

            //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }

    //Обмен элементов массива
    private static void extracted(int[] array, int indexOne, int indexTwo) {
        int tmp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = tmp;
    }
}
