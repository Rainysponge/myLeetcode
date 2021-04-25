package LC;

import java.util.*;

public class lc12 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        Map<Integer, String> dic = new HashMap<>();
        dic.put(4, "IV");  dic.put(500, "D");
        dic.put(9, "IX");  dic.put(100, "C");
        dic.put(40, "XL"); dic.put(50, "L");
        dic.put(90, "XC"); dic.put(10, "X");
        dic.put(400, "CD");dic.put(5, "V");
        dic.put(900, "CM");dic.put(1, "I");
        dic.put(1000, "M");
        int[] digits = new int[]{1000, 500, 100, 50, 10, 5, 1};
        int d = 0;
        while(num>0){

            int remainder = num % 10;
            if(remainder==0){
                d++;
                num /= 10;
                continue;
            }
            int realNum = remainder;
            for(int i=0; i<d; i++){
                realNum *= 10;
                // System.out.print("2");
            }
            // System.out.print("1");
            if(dic.containsKey(realNum)){
                res.insert(0, dic.get(realNum));
            }else{
                // 800 300 20 3
                StringBuilder tmpStr = new StringBuilder();
//                Deque<String> tmpStack = new LinkedList<>();
                for(int digit: digits){
                    if(realNum>=digit){

                        int t = realNum / digit;
                        for(int i=0; i<t; i++){
                            tmpStr.append(dic.get(digit));
                        }
//                        System.out.println(realNum+"\t"+tmpStr.toString()+"\t");
                        realNum = realNum % digit;
                    }
                }
                res.insert(0,tmpStr.toString());
            }

            num /= 10;
            d++;  // 位数
        }

//        res.h

        return res.toString();

    }
}
