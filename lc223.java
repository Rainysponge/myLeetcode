package LC;

public class lc223 {
    public int countDigitOne(int n) {
        //int countr = 0;
        //    for (long long i = 1; i <= n; i *= 10) {
        //        long long divider = i * 10;
        //        countr += (n / divider) * i + min(max(n % divider - i + 1, 0LL), i);
        //    }
        //    return countr;

        int res = 0;
        for(int i = 1; i<=n; i*=10){
            int d = i*10;
            res += (n/d)*i + Math.min(Math.max(n % d -i +1, 0), i);
        }


        return res;
    }
}
