package LC;

public class MS0805 {
    public int multiply(int A, int B) {
        // return A * B;
        int d = 1, t = 0;
        // 13 = 3 * 4 +1

        int two = 2;
        while(two < B){
            two = two * 2;
            d++;
        }
        d--;
        two /= 2;

        t = B / two;  // 倍数
        int remain = B % two;

        int res = 0;
        int tt = A << d;
        for(int i=0; i<t; i++){
            res += tt;
        }
        for(int i=0; i<remain; i++){
            res += A;
        }

        return res;
    }
}
