#
# @lc app=leetcode.cn id=279 lang=python3
#
# [279] 完全平方数
#

# @lc code=start
class Solution:
    def numSquares(self, n: int) -> int:
        # dp超时
        # dp = [float(inf) for _ in range(n+1)]
        # dp[1] = 1
        # dp[0] = 0
        # for i in range(2,n+1):
        #     j = 1
        #     while j**2<=i:
        #         dp[i] = min(dp[i],dp[i-j*j]+1)
        #         j += 1
        # return int(dp[-1])

        # dp = [i for i in range(n + 1)]
        # for i in range(1, n + 1):
        #     for j in range(1, n + 1):
        #         if i - j * j >= 0:
        #             dp[i] = min(dp[i], dp[i - j * j] + 1)
        #         else:
        #             break
        # return dp[n]

        # bfs
        INT_MAX = float(inf)
        q = collections.deque()
        dist = [INT_MAX] * (n+1)
        dist[0] = 0
        q.append(0)
        while q:
            t = q[0]
            q.popleft()
            if t == n:
                return int(dist[t])
            i = 1
            while t+i*i<=n:
                j = t+i*i
                if dist[j] > dist[t] + 1:
                    dist[j] = dist[t] + 1
                    q.append(j)
                i += 1
        return 0

# @lc code=end

