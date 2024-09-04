import java.util.Arrays;

public class lc2844 {
    public int minimumOperations(String num) {
        // 先找0 再找0 或者5
        int res = 0;
        int n = num.length();
        boolean zero_flag = false;
        boolean five_flag = false;
        for (int i = n - 1; i >= 0; --i) {
            if (num.charAt(i) == '5' || num.charAt(i) == '0'){
                if (zero_flag) {
                    return n - i - 2;
                }
                if (num.charAt(i) == '0') {
                    zero_flag = true;
                } else {
                    five_flag = true;
                }
            } else if (num.charAt(i) == '2' || num.charAt(i) == '7') {
                if (five_flag) {
                    return n - i - 2;
                }
            }

        }
        if (zero_flag) {
            return n - 1;
        }
        return res;
    }
}
