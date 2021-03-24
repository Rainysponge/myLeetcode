#
# @lc app=leetcode.cn id=456 lang=python3
#
# [456] 132模式
#

# @lc code=start
class Solution:
    def find132pattern(self, nums: List[int]) -> bool:

        stack = []
        Min = float('-inf')
        for i in range(len(nums)-1,-1,-1):
            if nums[i] < Min:
                return True
            while stack and nums[i] > stack[-1]:
                Min = stack.pop()
            stack.append(nums[i])
        return False

# @lc code=end

