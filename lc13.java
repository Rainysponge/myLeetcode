package LC;

import java.util.HashMap;
import java.util.Map;

public class lc13 {
    public int romanToInt(String s) {
        Map<String, Integer> dic = new HashMap<>();
        //字符          数值
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        //I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
        //X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
        //C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
        dic.put("I", 1);dic.put("V", 5);dic.put("X", 10);dic.put("L", 50);
        dic.put("C", 100);dic.put("D", 500);dic.put("M", 1000);
        dic.put("IV", 4);dic.put("IX", 9);dic.put("XL", 40);
        dic.put("XC", 90);dic.put("CD", 500);dic.put("CM", 900);

        // * 4 / 5
        char[] s1 = s.toCharArray();
        int res = 0;
        int N = s1.length, i = 0;


        while(i < N){
            String t = "";
            if(i<N-1){
                if(dic.containsKey(s.substring(i, i+2))){
                    res += dic.get(s.substring(i, i+2));
                    i += 2;
                }else{
                    res += dic.get(s.substring(i, i+1));
                    i++;
                }
            }else{
                res += dic.get(s.substring(i, i+1));
                i++;
            }

        }

        return res;

    }
}
