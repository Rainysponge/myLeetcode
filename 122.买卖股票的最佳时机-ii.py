#
# @lc app=leetcode.cn id=122 lang=python3
#
# [122] 买卖股票的最佳时机 II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 找极值
        i = 0
        earned = 0
        buy = 0
        while i < len(prices)-1:
            while i<len(prices)-1 and prices[i+1]<=prices[i]:
                i += 1
            buy = i
            while i<len(prices)-1 and prices[i+1]>=prices[i]:
                i += 1
            sell = i
            earned += prices[sell] - prices[buy]
        return earned
        
        
# @lc code=end

