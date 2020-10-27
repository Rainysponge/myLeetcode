#
# @lc app=leetcode.cn id=121 lang=python3
#
# [121] 买卖股票的最佳时机
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 第一反应不是动态规划而是递减栈,但买股票和算面积
        # 有所不同，所以不能怎么做,如case103[7,1,5,3,6,4]
        # 但好像不用动态规划呀
        if len(prices) < 2:
            return 0
        res = 0
        P_min = prices[0]
        for i in prices:
           P_min = min(P_min, i)
           res = max(res, i-P_min)
        return res
        
                



# @lc code=end

