#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        s_len = len(s)
        def measure(s,l,r):
            while l>=0 and r<s_len and s[r] == s[l]:
                r += 1
                l -= 1
            return r-l-1
        
        max_long = 0
        start = 0
        end = 0
        for i in range(s_len):
            l1 = measure(s,i,i)  # 这个是从两边开始
            l2 = measure(s,i,i+1)  # 这个为偶数
            max_long = max(l1,l2)

            if max_long > end - start:
                start = i - (max_long-1)//2
                end = i + (max_long)//2
        return s[start:end+1]

           
# @lc code=end

