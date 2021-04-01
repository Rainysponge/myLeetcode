/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int i = 0;
        while (i<citations.length && citations[citations.length-1-i] > i){
            // 逆序遍历
            i++;
        }

        return i;
    }
}
// @lc code=end

