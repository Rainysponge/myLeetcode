#
# @lc app=leetcode.cn id=4 lang=python3
#
# [4] 寻找两个有序数组的中位数
#

# @lc code=start
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        num_sum = nums1 + nums2
        num_sum = sorted(num_sum)
        t = len(num_sum)-1
        if t%2 == 0:
            t = t//2
            return num_sum[t]
        else:
            l = (t-1)//2
            r = (t+1)//2
            return (num_sum[l]+num_sum[r])/2

# @lc code=end

