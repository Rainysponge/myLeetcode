package LC;

public class lc476 {
    public int findComplement(int num) {
        int sum = 1;
        int t = num;
        t = t << 1;
        while(t > 0){
            sum = (sum << 1) + 1;
            t <<= 1;
        }

        return sum - num;
    }
}
