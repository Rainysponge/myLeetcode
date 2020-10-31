#
# @lc app=leetcode.cn id=167 lang=python3
#
# [167] 两数之和 II - 输入有序数组
#

# @lc code=start
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        nums_hash = {}
        t = len(numbers)
        l = range(t)
        for i in l:
            delta = target - numbers[i]
            if delta in nums_hash:
                return [nums_hash[delta]+1,i+1]
            nums_hash[numbers[i]] = i
        return []
# @lc code=end

