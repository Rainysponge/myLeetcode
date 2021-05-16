package LC;

public class MS0507 {
    public int exchangeBits(int num) {
        int left = num<<1;
        int right = num>>1;
        int one =1,two =2,leftt=0,rightt=0;
        for(int i=0;i<16;i++){
            leftt|=two;
            rightt|=one;
            one<<=2;
            two<<=2;
        }
        left &=leftt;
        right &=rightt;
        return left|right;



    }
}
