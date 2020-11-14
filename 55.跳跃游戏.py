#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # m = len(nums)
        # if m <= 1:
        #     return True
        # reach = 0
        # point = 0
        # for i in range(m):
        #     if i > reach:
        #         return False
        #     reach = max(reach, i+nums[i])
        # return True

        reach = 0
        i = 0
        n = len(nums)
        while i<n and i<= reach:
            reach = max(i+nums[i], reach)
            i += 1
        return i==n
        
# @lc code=end

