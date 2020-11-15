#
# @lc app=leetcode.cn id=135 lang=python3
#
# [135] 分发糖果
#

# @lc code=start
class Solution:
    def candy(self, ratings: List[int]) -> int:
        candyList = [1 for _ in range(len(ratings))]
        for i in range(len(ratings)-1):
            if ratings[i] < ratings[i+1]:
                candyList[i+1] = candyList[i] + 1
        for i in range(len(ratings)-1,0,-1):
            if ratings[i] < ratings[i-1]:
                candyList[i-1] = max(candyList[i]+1, candyList[i-1])
        return sum(candyList)
        

# @lc code=end

