package LC;

import java.util.HashMap;
import java.util.Map;

public class lc633 {
    public boolean judgeSquareSum(int c) {
        // 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
//        Map<Integer, Integer> dic = new HashMap<>();
//        int index = 1;
//        while(index*index<=c){
//            if(dic.containsKey(index*index)){
//                return true;
//            }
//            int sub = c - index*index;
//            dic.put(sub, 1);
//            index++;
//
//
//        }
//        return false;


        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;





    }
}
