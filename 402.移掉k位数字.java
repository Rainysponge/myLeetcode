/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

// @lc code=start
class Solution {
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
// @lc code=end

