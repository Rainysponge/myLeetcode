#
# @lc app=leetcode.cn id=46 lang=python
#
# [46] 全排列
#

# @lc code=start
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        mark = [False]*len(nums)
        outcome = []
        curr = []
        self.core(mark,nums,curr,outcome)
        return outcome

    def core(self, mark, nums, curr, outcome):
        if sum(mark)==len(nums):
            outcome.append(curr[:])
        for i in range(len(nums)):
            if mark[i]:
                continue
            curr.append(nums[i])
            mark[i]=True
            self.core(mark,nums,curr,outcome)
            mark[i]=False
            curr.pop()


# @lc code=end

