#
# @lc app=leetcode.cn id=229 lang=python3
#
# [229] 求众数 II
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        # hashTable 暴力可解但空间复杂度过高
        # 摩尔投票法
        m = len(nums)
        if m <= 1:
            return [] if m == 0 else [nums[0]]
        count1 = 0
        count2 = 0
        num1 = 0
        num2 = 0
        res = []
        key = m // 3
        for item in nums:
            if num1 == item:
                count1 += 1
            elif num2 == item:
                count2 += 1
            elif count1 == 0:
                num1 = item
                count1 = 1
            elif count2 == 0:
                num2 = item
                count2 = 1
            else:
                count2 -= 1
                count1 -= 1
        count1 = 0
        count2 = 0
        for item in nums:
            if num1 == item:
                count1 += 1
            if num2 == item:
                count2 += 1
        if count1 > key and num1 != num2:
            res.append(num1)
        if count2 > key and num1 != num2:
            res.append(num2)
        if count1 > key and num1 == num2:
            res.append(num1)
        return res
            

# @lc code=end

