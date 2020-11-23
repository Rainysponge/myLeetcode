#
# @lc app=leetcode.cn id=123 lang=python3
#
# [123] 买卖股票的最佳时机 III
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # Time Limit Exceeded 通过记忆化改进
        # if not prices:
        #     return 0
        # n = len(prices)
        # dic = {}
        # def dfs(index, status, k):
        #     # k表示交易次数
        #     if k ==2 or index == n:
        #         return 0
        #     if (index, status, k) in dic:
        #         return dic[index, status, k]
        #     a, b, c = 0, 0, 0
        #     a = dfs(index+1, status, k)
        #     if status:
        #         # 卖
        #         b = dfs(index+1, 0, k+1) + prices[index]
        #     else:
        #         c = dfs(index+1, 1, k) - prices[index]
        #     dic[index, status, k] = max(a,b,c)
        #     return dic[index, status, k]
        # return dfs(0,0,0)

        # dp

        if not prices:
            return 0
        n = len(prices)
        if n<2:
            return 0
        # 定义二维数组，5种状态    
        dp = [[-1 for _ in range(5)] for _ in range(n)]
        # 初始化第一天的状态
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        dp[0][2] = 0
        dp[0][3] = -prices[0]
        dp[0][4] = 0
        for i in range(1,n):
            # dp[i][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0] = 0
            # 处理第一次买入、第一次卖出
            dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
            dp[i][2] = max(dp[i-1][2],dp[i-1][1]+prices[i])
            # 处理第二次买入、第二次卖出
            dp[i][3] = max(dp[i-1][3],dp[i-1][2]-prices[i])
            dp[i][4] = max(dp[i-1][4],dp[i-1][3]+prices[i])
        # 返回最大值    
        return max(dp[-1][0],dp[-1][1],dp[-1][2],dp[-1][3],dp[-1][4])

# 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/










# @lc code=end

