#
# @lc app=leetcode.cn id=504 lang=python3
#
# [504] 七进制数
#

# @lc code=start
class Solution:
    def convertToBase7(self, num: int) -> str:
        flag = 1  # 1为正
        if num == 0:
            return '0'
        if num < 0:
            flag = 0

        num = abs(num)
        res = ''
        while num > 0:
            res += str(num % 7)
            num = num // 7
        res = res[::-1]
        return res if flag > 0 else '-' + res

        
# @lc code=end

