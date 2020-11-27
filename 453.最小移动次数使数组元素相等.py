#
# @lc app=leetcode.cn id=453 lang=python3
#
# [453] 最小移动次数使数组元素相等
#

# @lc code=start
class Solution:
    def minMoves(self, nums: List[int]) -> int:
        # 每次移动让剩余的n-1个数加1，相当于每次移动让选定的那个数减1
        return sum(nums)- min(nums) * len(nums)
# @lc code=end

