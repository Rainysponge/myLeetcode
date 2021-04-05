/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int sLength = s.length();
        int start = 0, end = 0;

        int maxLength = 0;
        for(int i=0; i<sLength; i++){
            int oddLength = measure(s, i, i);
            int evenLength = measure(s, i, i+1);
            maxLength = Math.max(oddLength, evenLength);
            if (maxLength > end - start){
                start = i - (maxLength - 1) / 2;  
                // 这里减1是处理evenLength较大时可能出现的问题
                end = i + maxLength / 2;
            }
        }


        return s.substring(start, end+1);
    }

    public int measure(String s, int l, int r){
        int sLength = s.length();
        while(l>=0 && r<sLength && s.charAt(r)==s.charAt(l)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
// @lc code=end

