package LC;

import java.util.*;

public class lc726 {
    int N, index;
    String s;
    public String countOfAtoms(String formula) {
        String res = "";
        N = formula.length();
        index = 0;
        s = formula;

        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<String, Integer>());
        while(index < N){
            char c = formula.charAt(index);
            if(c == '('){
                index++;
                stack.push(new HashMap<String, Integer>());
            }else if(c == ')'){
                index++;
                int num = ParseNum();
                Map<String, Integer> popMap = stack.pop();
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                }
            }else{
                // 是字母
                String atom = ParseAtom();
                int num = ParseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量

            }
        }
        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map);

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();

    }

    String ParseAtom(){
        StringBuffer strB = new StringBuffer();
        strB.append(s.charAt(index++));
        while(index < N && Character.isLowerCase(s.charAt(index))){
            strB.append(s.charAt(index++));
        }

        return strB.toString();
    }

    int ParseNum(){
        if(index == N || !Character.isDigit(s.charAt(index))){
            // 不是数字，则前面的原子个数为1
            return 1;
        }

        int num = 0;
        while(index < N && Character.isDigit(s.charAt(index))){
            num = num * 10 + s.charAt(index++) - '0';
        }

        return num;
    }

}
