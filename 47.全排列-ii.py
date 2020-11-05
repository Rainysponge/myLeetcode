#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        tmp = []
        n = len(nums)
        used = [False for _ in range(n)]

        def core(depth):
            if depth == n:
                ans.append(tmp[:])
                return 0
            for i in range(n):
                if i > 0 and nums[i]==nums[i-1] and not used[i-1]:
                    continue

                if used[i]:
                    continue

                tmp.append(nums[i])
                used[i] = True
                core(depth+1)
                tmp.pop()
                used[i] = False
        core(0)
        return ans



# @lc code=end

