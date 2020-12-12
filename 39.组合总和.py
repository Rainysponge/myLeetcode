#
# @lc app=leetcode.cn id=39 lang=python3
#
# [39] 组合总和
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates = sorted(candidates)
        res = []
        def dfs(target, tmp, t):
            if not target:
                res.append(tmp)
            if target < 0:
                return
            
            for i in range(t, len(candidates)):
                dfs(target-candidates[i], tmp+[candidates[i]], i)
        dfs(target, [], 0)
        return res
# @lc code=end

