#
# @lc app=leetcode.cn id=90 lang=python3
#
# [90] 子集 II
#

# @lc code=start
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        res = []
        def sub_set(start, num):
            num = sorted(num)
            if num not in res:
                res.append(num)
            for i in range(start, len(nums)):
                sub_set(i+1, num+[nums[i]])
        sub_set(0,[])
        return res
# @lc code=end

