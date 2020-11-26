#
# @lc app=leetcode.cn id=319 lang=python3
#
# [319] 灯泡开关
#

# @lc code=start
class Solution:
    def bulbSwitch(self, n: int) -> int:
        i = 1
        res = []
        while i * i <= n:
            res.append(i*i)
            i += 1
        return len(res)
# @lc code=end

