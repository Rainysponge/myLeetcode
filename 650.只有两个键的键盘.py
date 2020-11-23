#
# @lc app=leetcode.cn id=650 lang=python3
#
# [650] 只有两个键的键盘
#

# @lc code=start
class Solution:
    def minSteps(self, n: int) -> int:
        # dp = [float(inf) for i in range(n+1)]
        # dp[0], dp[1] = 0, 0
        # for i in range(2, n+1):
        #     for j in range(1, i):
        #         if i % j == 0:
        #             dp[i] = min(dp[i], dp[j] + i/j)
        # return int(dp[-1])
        # 先让 i 从 2 开始遍历找到 n - 1，判断 i 是不是 n 
        # 的因子，如果 i 是 n 的因子，那么总的需要操作 
        # minSteps(i) + n / i次。如果从 2 到 n - 1 没
        # 有 n 的因子，那么 n 是个素数，必须操作 n 次。
        if n == 1:
            return 0
        for i in range(2, n):
            if n % i == 0:
                return self.minSteps(n // i) + i
        return n
        # 看了 36 个 'A' 的分解之后，我们发现题目要求的就是
        #  36 的所有素因子之和。素因子是指，该因子不可再次拆分。
        # res = 0
        # d = 2
        # while n > 1:
        #     while n % d == 0:
        #         res += d
        #         n //= d
        #     d += 1
        # return res
        
# @lc code=end

