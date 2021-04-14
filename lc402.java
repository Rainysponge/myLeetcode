package LC;

import java.util.Deque;
import java.util.LinkedList;

//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
// 单调栈 + 贪心
public class lc402 {
    public String removeKdigits(String num, int k) {
//        int remain = num.length() - k;
        Deque<Character> deque = new LinkedList<Character>();
        int l = num.length();
        for(int i=0; i<l; i++){
            char data = num.charAt(i);
            while (!deque.isEmpty() && deque.peekLast()>data && k>0){
                deque.pollLast();
                k--;
            }
            deque.offerLast(data);
        }
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;  // 前面的0
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();

    }
}
