package LC;

import java.util.ArrayList;
import java.util.Stack;

public class lc402 {
    public String removeKdigits(String num, int k) {
        if(num.length()==0||num.length()<=k)
            return "0";
        char[] strStack =new char[num.length()];
        int newLength=num.length()-k;
        int top=0;
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            while(top>0&&strStack[top-1]>c&&k>0){
                top--;
                k--;
            }
            strStack[top++]=c;
        }
        int index=0;
        while(index<newLength&&strStack[index]=='0')
            index++;
        return index==newLength?"0":new String(strStack,index,newLength-index);
    }

}


