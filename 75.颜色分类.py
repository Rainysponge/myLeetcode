#
# @lc app=leetcode.cn id=75 lang=python3
#
# [75] 颜色分类
#

# @lc code=start
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 计数排序 时间复杂度是O(n)级别的，
        # 而空间复杂度和我们统计的数的个数有关

        # count = [0, 0, 0]
        # for i in nums:
        #     count[i] += 1
        
        # index = 0
        # for i, num in enumerate(count):
        #     for _ in range(num):
        #         nums[index] = i
        #         index += 1

        # 真一次遍历 多指针
        right, left = -1, len(nums)
        i = 0
        while i < left:
            if nums[i] == 1:
                i += 1
            elif nums[i] == 0:
                right += 1
                nums[right], nums[i] = nums[i], nums[right]
                i += 1
            elif nums[i] == 2:
                left -= 1
                nums[left], nums[i] = nums[i], nums[left]
            # i += 1
        
                






# @lc code=end

