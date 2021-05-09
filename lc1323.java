package LC;

import java.util.Deque;
import java.util.LinkedList;

public class lc1323 {
    public int maximum69Number (int num) {
        Deque<Integer> stack = new LinkedList<>();
        while(num>0){
            int t = num % 10;
            stack.push(t);
            num = num / 10;
        }
        int res = 0;
        boolean flag = true;
        while(!stack.isEmpty()){
            int t = stack.pop();
            if(t==9){
                res = res*10 + t;
            }else{
                if(flag){
                    res = res * 10 + 9;
                    flag = false;
                }else{
                    res = res * 10 + 6;
                }
            }
        }
        return res;

    }
}
