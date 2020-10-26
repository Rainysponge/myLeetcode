#
# @lc app=leetcode.cn id=39 lang=python3
#
# [39] 组合总和
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates = sorted(candidates)
        List = []
        def dfs(target,stack):
            if target == 0:
                List.append(stack)
                return
            for i in candidates:
                if target < i :
                    break
                if stack and stack[-1]>i:
                    continue
                else:
                    dfs(target-i,stack+[i])
        dfs(target,[])
        return List
# @lc code=end

