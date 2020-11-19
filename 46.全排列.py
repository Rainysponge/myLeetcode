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
        res = []
        if not nums:
            return[]
        visited = [False for _ in range(len(nums))]
        tmp = []
        self.backtrace(visited, nums, tmp, res)
        return res
        
    def backtrace(self, visited, nums, tmp, res):
        if sum(visited) == len(nums):
            res.append(tmp[:])
            # 浅拷贝
            return
        for i in range(len(nums)):
            if visited[i]:
                continue
            visited[i] = True
            tmp.append(nums[i])
            self.backtrace(visited, nums, tmp, res)
            visited[i] = False
            tmp.pop()
        return
        


# @lc code=end

