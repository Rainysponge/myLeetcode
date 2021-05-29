package LC;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc1190 {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] s1 = s.toCharArray();
        int N = s1.length;
        StringBuilder res = new StringBuilder();
        res.append("");
        int countLeft = 0;
        for(int i=0; i<N; i++){
            if(s1[i] == '('){
                countLeft++;
                stack.push(s1[i]);
                continue;
            }
            if(countLeft==0){
                while(!stack.isEmpty()){
                    res.append(stack.pop());
                }
                res.append(s1[i]);
                System.out.println(res.toString());
            }else{
                if(s1[i] != ')'){
                    stack.push(s1[i]);
                }else{
                    countLeft--;
                    List<Character> tmp = new ArrayList<>();
                    char t = stack.pop();
                    while(t!='('){
                        tmp.add(t);
                        t = stack.pop();
                    }
//                    for(Character c: tmp){
//                        System.out.print(c);
//                    }
//                    System.out.println("");
                    if(countLeft>0) {
                        for (Character character : tmp) {
                            stack.push(character);
                        }
                    }else{
                        for (Character character : tmp) {
                            res.append(character);
                        }
                    }


                }
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();

    }
}
