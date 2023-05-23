import java.util.Arrays;

//тесты для сравнения производительности сортировки больших массивов.
//2.Для наглядного результата стоит сравнивать массивы до 100 000 элементов.
//При таком подходе будет явно видно, какая из сортировок окажется быстрее.
public class SeminarOne {
    public static void main(String[] args) {
        int [] arrayTest = new int[]{1,2,100,4,6,55,8,100,10,100,200};
        quickSort(arrayTest,0,arrayTest.length-1);
        System.out.println(Arrays.toString(arrayTest));
        System.out.println(binarySearch(arrayTest,6,0,arrayTest.length-1));
//        for (int i = 10000; i <= 100000; i = i + 10000) {
//            int[] array = new int[i];
//            for (int j = 0; j < array.length; j++) {
//                array[j] = (int) (Math.random() * 10000);
//            }
//            Date startDate = new Date();
//            bubbleSort(array);
//            Date endDate = new Date();
//            long bubbleSortDuration = endDate.getTime() - startDate.getTime();
//
//            for (int j = 0; j < array.length; j++) {
//                array[j] = (int) (Math.random() * 10000);
//            }
//            startDate = new Date();
//            quickSort(array,0, array.length-1);
//            endDate = new Date();
//            long quickSortDuration = endDate.getTime() - startDate.getTime();
//            System.out.printf("i: %s, bubble sort duration: %s, quick sort duration: %s%n", i, bubbleSortDuration,
//                    quickSortDuration);
        }

    public static void quickSort(int[] array, int start, int end){
        int pivot=array[(end-start)/2+start];
        int leftPosition = start;
        int rightPosition = end;
        while (leftPosition<=rightPosition){
            while (array[leftPosition]<pivot){
                leftPosition++;
            }
            while ((array[rightPosition]>pivot)){
                rightPosition--;
            }
            if (leftPosition<=rightPosition){
                if (leftPosition<rightPosition){
                    int temp = array[rightPosition];
                    array[rightPosition]=array[leftPosition];
                    array[leftPosition]=temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        if (start<rightPosition){
            quickSort(array, start, rightPosition);
        }
        if (end>leftPosition){
            quickSort(array, leftPosition, end);
        }
    }

    public static void bubbleSort(int[] a) {
        int lastSwap = a.length - 1;
        for (int i = 1; i < a.length; i++) {
            boolean is_sorted = true;
            int currentSwap = -1;
            for (int j = 0; j < lastSwap; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = false;
                    currentSwap = j;
                }
            }
            if (is_sorted) return;
            lastSwap = currentSwap;
        }
    }

    public static int binarySearch(int[] array, int value, int min, int max){
        int midlePosition;
        if (max<min) return -1;
        else midlePosition = (max-min)/2+min;
        if (array[midlePosition]<value){
            return binarySearch(array, value,midlePosition+1, max);
        } else if(array[midlePosition]>value){
            return binarySearch(array,value,min,midlePosition-1);
        }else return midlePosition;
    }
}

