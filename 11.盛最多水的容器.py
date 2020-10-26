#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        right = len(height) - 1
        area = 0
        left = 0
        while left<right:
            width = right - left
            if(height[left]>height[right]):
                h = height[right]
                right-=1
            else:
                h = height[left]
                left +=1
            area = max(area,h*width)
        return area
# @lc code=end

