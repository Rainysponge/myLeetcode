#
# @lc app=leetcode.cn id=575 lang=python3
#
# [575] 分糖果
#

# @lc code=start
class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        if not candyType:
            return 0
        count = collections.Counter(candyType)
        # return count
        # return len(count) // 2 + 1
        return min(len(count), len(candyType) // 2)
            
# @lc code=end

