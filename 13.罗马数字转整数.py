#
# @lc app=leetcode.cn id=13 lang=python3
#
# [13] 罗马数字转整数
#

# @lc code=start
class Solution:
    def romanToInt(self, s: str) -> int:
        dict_nums = {'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        s_len = len(s)
        result = 0
        for i in range(s_len):
            if i+1<s_len and dict_nums[s[i]]<dict_nums[s[i+1]]:
                result -= dict_nums[s[i]]
            else:
                result += dict_nums[s[i]]
        return result
# @lc code=end

