package LC;

import java.util.*;

public class lc394 {
    int index = 0;
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        int sLen = s.length();

        while(index<sLen){
            char cur = s.charAt(index);
            if(Character.isDigit(cur)){
                stack.push(checkDigit(s));
            }else if(Character.isLetter(cur) || cur=='['){
                stack.push(String.valueOf(cur));
                index++;
            }else {
                // 检测到']'
                index++;
                Deque<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peek())){
                    sub.add(stack.pop());
                }
                String number = stack.pop();
                stack.push(ChangeToString(number, sub));

            }
        }


        return new StringBuffer(ChangeToString("1", stack)).reverse().toString();

    }
    private String checkDigit(String s){
        StringBuilder res = new StringBuilder();
        while(Character.isDigit(s.charAt(index))){
            res.append(s.charAt(index));
            index++;
        }
        return res.toString();

    }

    private String ChangeToString(String number, Deque<String> sub){
        StringBuilder res = new StringBuilder();
        StringBuilder tmpStr = new StringBuilder();
        int turn = Integer.parseInt(number);
        while(!sub.isEmpty()){
            tmpStr.append(sub.pop());
        }

        res.append(tmpStr.toString().repeat(Math.max(0, turn)));
        return res.toString();

    }

}
