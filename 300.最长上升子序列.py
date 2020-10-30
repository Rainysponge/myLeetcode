#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#

# @lc code=start
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # if not nums:
        #     return 0
        # left = 0
        # right = len(nums) - 1
        # dp = [1 for _ in range(len(nums))]
        
        # mid = (right + left) // 2
        # for i in range(right + 1):
        #     for j in range(i):
        #         if nums[i] > nums[j]:
        #             dp[i] = max(dp[i],dp[j]+1)
        # return max(dp)
        # 
        # nlogn 二分查找
        def binary_search(num, List):
            start = 0
            l = len(List)
            end = l - 1
            while start<end:
                mid = (start+end) // 2
                if List[mid+1] > num > List[mid]:
                    return mid + 1
                if num > List[mid]:
                    start = mid + 1
                else:
                    end = mid
        if not nums:
            return 0
        res = [nums[0]]
        for num in nums[1:]:
            if num > res[-1]:
                res.append(num)
            elif num < res[0]:
                res[0] = num
            elif num in res:
                continue
            elif num < res[-1]:
                n = binary_search(num, res)
                res[n] = num
        return len(res)

          


        
# @lc code=end

