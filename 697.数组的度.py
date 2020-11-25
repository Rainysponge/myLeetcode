#
# @lc app=leetcode.cn id=697 lang=python3
#
# [697] 数组的度
#

# @lc code=start
class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        counts = collections.Counter(nums)
        left, right = {}, {}  #定义两个字典，存左右边界
        for i, num in enumerate(nums):
            #如果字典中包含有给定键，则返回该键对应的值，否则返回为该键设置的值。这样一来取得都是左边的
            left.setdefault(num, i) 
            #for 循环过程中，每一次都会更新值，最后一次执行时，right存下的都是最右边的边界
            right[num] = i
        degree = max(counts.values())
        res = min(right[num]-left[num]+1 for num in counts.keys() if counts[num] == degree)
        return res
# @lc code=end

