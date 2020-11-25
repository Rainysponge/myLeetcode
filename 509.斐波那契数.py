#
# @lc app=leetcode.cn id=509 lang=python3
#
# [509] 斐波那契数
#

# @lc code=start
class Solution:
    def fib(self, N: int) -> int:
        if N == 0:
            return 0
        if N <= 2:
            return 1
        List = [1 for _ in range(N+1)]
        for i in range(3, N+1):
            List[i] = List[i-1] + List[i-2]
        return List[-1]
        
# @lc code=end

