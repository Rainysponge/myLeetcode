#
# @lc app=leetcode.cn id=220 lang=python3
#
# [220] 存在重复元素 III
#

# @lc code=start
class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        # 第一反应 桶排序
        # Min = min(nums)
        # Max = max(nums)
        # if t==0:


        # 要放入的桶中已经有其他元素了，这时将nums[i]放进去满足差值<=t
        # 可能存在前面一个桶的元素并且与nums[i]的差值<=t 或者 存在后面一个桶的元素并且与nums[i]的差值<=t



        if t < 0 or k < 0:
            return False

        buckets_size = t + 1
        buckets = {}

        for i in range(len(nums)):
            buckets_num = nums[i] // buckets_size
            if buckets_num in buckets:
                return True
            
            buckets[buckets_num] = nums[i]

            # 检查前后
            if (buckets_num-1) in buckets and abs(buckets[buckets_num-1] - nums[i]) <= t:
                return True
            if (buckets_num+1) in buckets and abs(buckets[buckets_num+1] - nums[i]) <= t:
                return True

            if i >= k:
                buckets.pop(nums[i-k]//buckets_size)
        return False




# @lc code=end

