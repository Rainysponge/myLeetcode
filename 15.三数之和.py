#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        L_list = len(nums)
        if L_list <3:
            return []
        nums = sorted(nums)
        result = []
        for i in range(L_list-2):
            if i>0 and nums[i] == nums[i-1]:
                continue
            l = i+1
            r = L_list -1
            while(l<r):
                t = nums[i]+nums[l]+nums[r]
                if  t == 0:
                    result.append([nums[i],nums[l],nums[r]])
                    r -=1
                    l +=1
                    while l<r and nums[r] == nums[r+1]:
                        r -= 1
                    while l<r and nums[l] == nums[l-1]:
                        l += 1
                        #去重是注意要与前面的项进行匹配，顾与l-1ander+1比较
                elif t>0:
                    r -= 1
                else:
                    l += 1
        return result
            

# @lc code=end

