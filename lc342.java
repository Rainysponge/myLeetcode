package LC;

public class lc342 {
    public boolean isPowerOfFour(int n) {
        while (n > 1){
            if ((n & 11) > 0){
                return false;
            }
            n = n >> 2;
        }
        return n == 1;
    }
}
