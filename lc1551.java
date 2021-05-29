package LC;

public class lc1551 {
    public int minOperations(int n) {
        int t = n / 2;

        if(n % 2 == 0){
            return t * t;
        }else{
            return (t+1) * t;
        }
    }
}
