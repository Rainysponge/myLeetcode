package LC;

public class lc371 {
    public int getSum(int a, int b) {
//        if(a == 0 || b == 0){
//            return a | b;
//        }
//
//
//        int[] aBin = new int[11];
//        int[] bBin = new int[11];
//        int[] res = new int[11];
//
//        boolean aPositive = a > 0;
//        boolean bPositive = b > 0;
//
//
//
//        if(!aPositive){
//            a = Math.abs(a);
//            aBin[10] = 1;
//        }
//        if(!bPositive){
//            b = Math.abs(b);
//            bBin[10] = 1;  // 符号位
//        }
//
//        int index = 0;
//        while(a > 0){
//            aBin[index] = a & 1;
//            a = a >> 1;
//        }
//
//
//
//        index = 0;
//        while(b > 0){
//            bBin[index] = b & 1;
//            b = b >> 1;
//        }
//        int c = 0;
//        for(int i=0; i<11; i++){
//            res[i] = aBin[i] ^ bBin[i] ^ c;
//            c = (aBin[i] & bBin[i]) | (aBin[i] & c) | (bBin[i] & c);
//        }
//
//        if(res[10] > 0){
//            // 取反
//
//        }
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;


    }
}
