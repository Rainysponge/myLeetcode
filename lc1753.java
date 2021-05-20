package LC;

public class lc1753 {
    public int maximumScore(int a, int b, int c) {
        int t = 0;
        if(a > b){
            t = a;
            a = b;
            b = t;
        }
        // System.out.printf("%d %d %d\n", a, b, c);

        if(a > c){
            t = a;
            a = c;
            c = t;
        }
        // System.out.printf("%d %d %d\n", a, b, c);

        if(b > c){
            t = c;
            c = b;
            b = t;
        }
        // System.out.printf("%d %d %d", a, b, c);
        int res = 0;
        while(c-a < b){
            res++;
            a--;
            b--;
        }
        return res + a + Math.min(c-a, b);

    }
}
