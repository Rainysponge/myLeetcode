#
# @lc app=leetcode.cn id=215 lang=python3
#
# [215] 数组中的第K个最大元素
#

# @lc code=start
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # nums.sort()
        # return nums[-k]
        heapify(nums)  # 该方法没有返回值
        # res = 0
        # # while k:
        # #     k = k - 1
        # #     res = heappop(nums)
        return nlargest(k, nums)[-1]
        # # return nums
# @lc code=end

