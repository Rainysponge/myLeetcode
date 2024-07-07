import java.util.Arrays;

public class lc1491 {
    public double average(int[] salary) {
        int sum = Arrays.stream(salary).sum();
        int min = Arrays.stream(salary).min().getAsInt();
        int max = Arrays.stream(salary).max().getAsInt();

        int woMin = sum - min - max;

        int n = salary.length;
        if(n < 2){
            return 0;
        }
        return (double) woMin / (n-2);

    }
}
