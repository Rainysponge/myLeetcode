#
# @lc app=leetcode.cn id=258 lang=python3
#
# [258] 各位相加
#

# @lc code=start
class Solution:
    def addDigits(self, num: int) -> int:
        # 循环
        # while num>=10:
        #     tmp = num
        #     res = 0
        #     while tmp>0:
        #         tmp_in = tmp % 10
        #         res += tmp_in
        #         tmp = tmp // 10
        #     num = res
        # return num

        # O(1)
        
        return num%9 if num % 9 != 0 or num == 0 else 9


# @lc code=end

