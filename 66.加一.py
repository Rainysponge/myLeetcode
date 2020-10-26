#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # 直接在list里面修改
        if digits[-1] != 9:
            digits[-1] += 1
        else:
            if len(digits) > 1:
                i = 1
                while(digits[-i] == 9 and i < len(digits)):
                    digits[-i] = 0
                    i += 1
                if i == len(digits) and digits[0] == 9:
                    digits = [1]+[0]*len(digits)
                elif i == len(digits) and digits[0] != 9:
                    digits = [digits[0] + 1] + [0]*(i - 1)
                else:
                    digits[-i] += 1 
            else:
                digits = [1,0]
        return digits
# @lc code=end

