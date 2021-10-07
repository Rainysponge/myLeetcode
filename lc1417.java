package LC;

import java.util.ArrayList;
import java.util.List;

public class lc1417 {
    public String reformat(String s) {
        List<Character> digitList = new ArrayList<>();
        List<Character> cList = new ArrayList<>();

        char[] s1 = s.toCharArray();
        int N = s1.length;
        for(char c: s1){
            if(Character.isDigit(c)){
                digitList.add(c);
            }else {
                cList.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(digitList.size() <= cList.size() + 1 && digitList.size() >= cList.size() - 1){
            int i = 0;
            if(digitList.size() >= cList.size()){
                while(i < N){
                    if(i % 2 == 0){
                        sb.append(digitList.get(i/2));
                    }else{
                        sb.append(cList.get(i/2));
                    }
                    i++;
                }

            }else{
                while(i < N){
                    if(i % 2 == 0){
                        sb.append(cList.get(i/2));
                    }else{
                        sb.append(digitList.get(i/2));
                    }
                    i++;
                }
            }
        }else{
            return "";
        }

        return sb.toString();
    }
}
