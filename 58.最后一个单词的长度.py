#
# @lc app=leetcode.cn id=58 lang=python3
#
# [58] 最后一个单词的长度
#

# @lc code=start
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        ans = 0
        flag = 0
        for i in range(len(s)):
            j = len(s) - 1 - i
            if flag == 0 and s[j] == ' ':
                continue
            if 'a'<=s[j]<='z' or 'A'<=s[j]<='Z':
                flag = 1
                ans += 1
                continue
            else:
                break
        return ans    
# @lc code=end

