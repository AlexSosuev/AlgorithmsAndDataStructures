import java.util.Date;
public class Recursion {
    public static void main(String[] args) {
        test();
    }

    public static int Recursia(int n) {

        if (n <= 2) {
            return 1;
        }
        return Recursia(n - 1) + Recursia(n - 2);
    }
    public static int Fib(int n){
        if (n<=2){
            return 1;
        }
        int [] array = new int[n];
        array[0] =  1;
        array[1] =  1;
        for (int i=2; i < n; i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1];
    }
    public static void test() {
        for (int i = 10; i <= 50; i = i + 10) {
            Date startDate = new Date();
            Fib(i);
            Date endDate = new Date();
            long lineDuration = endDate.getTime() - startDate.getTime();
            startDate = new Date();
            Recursia(i);
            endDate = new Date();
            long recursiveDuration = endDate.getTime() - startDate.getTime();
            System.out.printf("i: %s, line duration: %s, recursive duration: %s%n", i, lineDuration, recursiveDuration);
        }
    }
}
