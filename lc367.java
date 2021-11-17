package LC;

public class lc367 {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;

        int left = 1;
        int right = num;
        int mid = (left + right) / 2;
        while(left < right){
            if(mid * mid <= num){
                left = mid;
            }else{
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }

        return left*left == num;
    }
}
