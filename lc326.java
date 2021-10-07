package LC;

public class lc326 {
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        if(n == 3) return true;
        int num = 0;
        int tmp = n;
        while(tmp > 0){
            num += tmp % 10;
            tmp = tmp / 10;
        }
        if(num % 9 == 0){
            // 可以被9整除
            n = n / 9;
            while(n > 0){
                if(n == 1) break;
                if(n % 3 == 0){
                    n = n / 3;
                }else{
                    return false;
                }
            }

        }else{
            return false;
        }
        return true;
    }
}
