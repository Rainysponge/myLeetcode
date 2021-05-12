package LC;

public class lc1734 {
    public int[] decode(int[] encoded) {
        int N = encoded.length;
        int[] res = new int[N+1];
        int t = 0;
        int tEncode = encoded[1];
        for(int i=1; i<N; i++){
            t ^= i;
        }
        for(int i=1; i<N; i+=2){
            tEncode ^= encoded[i];
        }
        res[0] = tEncode ^ t;

        for(int i=1; i<N+1; i++){
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;

    }
}
