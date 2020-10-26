#
# @lc app=leetcode.cn id=80 lang=python3
#
# [80] 删除排序数组中的重复项 II
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        Len_nums = len(nums)
        for n in nums:
            if i<2 or nums[i-2] != n:
                nums[i] = n
                # 当nums[i-2] != n不相等时，替换nums[i]
                # 类似双指针，i指向需要被替换的位置
                i += 1
        return i
# @lc code=end

