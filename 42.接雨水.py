#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
class Solution:
    def trap(self, height: List[int]) -> int:
        # 用left_max, right_max储存每个位置的左右最大值，在检索每个位置的雨量即可
        L = len(height)
        left_max = [0 for i in range(L)]
        right_max = [0 for i in range(L)]
        Sum = 0
        for i in range(L):
            r_i = L - i - 1
            if i == 0:
                left_max[i] = height[i]
                right_max[r_i] = height[r_i]
            else:
                left_max[i] = max(left_max[i-1],height[i])
                right_max[r_i] = max(right_max[r_i+1],height[r_i])
        for i in range(L):
            tmp = min(left_max[i],right_max[i])-height[i]
            if tmp<0:
                tmp = 0
            Sum += tmp 
        return Sum

# @lc code=end

