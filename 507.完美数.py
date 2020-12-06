#
# @lc app=leetcode.cn id=507 lang=python3
#
# [507] 完美数
#

# @lc code=start
class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1:
            return False
        res = [1]
        i = 2
        while i*i <= num:
            if num % i == 0:
                res.append(i)
                if not num // i == i:
                    res.append(num // i)
            i += 1
        return sum(res) == num

# @lc code=end

