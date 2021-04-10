package LC;

public class lc263 {
    public boolean isUgly(int n) {
        int[] contend = {2, 3, 5};
        for(int each: contend){
            while(n % each == 0){
                n /= each;
            }
        }
        return n == 1;
    }

}
