#
# @lc app=leetcode.cn id=645 lang=python3
#
# [645] 错误的集合
#

# @lc code=start
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        counts = collections.Counter(nums)
        List = [0, 0]
        for i in range(1, len(nums)+1):
            if i not in counts:
                List[1] = i
                continue
            if counts[i] == 2:
                List[0] = i
            # if counts[i]

        return List
# @lc code=end

