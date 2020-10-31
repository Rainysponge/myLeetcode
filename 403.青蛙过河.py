#
# @lc app=leetcode.cn id=403 lang=python3
#
# [403] 青蛙过河
#

# @lc code=start
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        # dp[stones[i]]表示在第i个石头上可以向前跳的
        # 步长的集合,跳到第i个石头时，用当前能跳的步
        # 长往前跳，若能跳到石头上，则该石头的步长集
        # 合中添加该步长，若最后一块石头的步长集合不
        # 为空，则返回True，反之为False

        if not stones:
            return True
        m = len(stones)
        dp = {}
        for i in range(m):
            dp[stones[i]] = set()
        if stones[1] - stones[0] == 1:
            dp[stones[1]] = set([1])
        else:
            return False
        
        for i in range(1,m):
            for item in dp[stones[i]]:
                for j in range(item-1,item+2):
                    if j > 0 and stones[i] + j in dp:
                        dp[stones[i]+j].add(j)
        return True if dp[stones[-1]] != set([]) else False


        

        
# @lc code=end

