#
# @lc app=leetcode.cn id=16 lang=python3
#
# [16] 最接近的三数之和
#

# @lc code=start
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums_len = len(nums)
        nums_sort = sorted(nums)
        if nums_len == 3 :
            return nums_sort[0]+nums_sort[1]+nums_sort[2]
        
        sub = 1000
        for i in range(nums_len-1):
            left = i+1
            right = nums_len - 1
            while(left<right):
                nums_sum = nums_sort[i]+nums_sort[left]+nums_sort[right]
                delta = nums_sum - target 
                if delta == 0 :
                    return nums_sum
                if abs(delta)<abs(sub):
                    sub = delta 
                if delta > 0:
                    right -= 1
                else:
                    left += 1
        
        return target+sub        

# @lc code=end

