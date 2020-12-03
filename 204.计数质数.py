#
# @lc app=leetcode.cn id=204 lang=python3
#
# [204] 计数质数
#

# @lc code=start
class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        res = [1 for _ in range(n)]
        res[0], res[1] = 0, 0
        for i in range(n):
            if res[i] == 1:
                # tmp = i
                r = 2
                while i * r < n:
                    res[i*r] = 0
                    r += 1
        return sum(res)
# @lc code=end

