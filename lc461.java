package LC;

public class lc461 {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int res = 0;
        while(t>0){
            res += t & 1;
            t = t >> 1;
        }
        return res;


    }

    private int hamming(int x, int y){
        // x >= y
        int res = 0;
        while(x > 0){
            int a = x % 2;
            int b = y % 2;
            if(a != b) res++;
            x = x >> 1;
            y = y >> 1;
        }
        return res;
    }
}
