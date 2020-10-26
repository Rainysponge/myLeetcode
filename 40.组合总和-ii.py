#
# @lc app=leetcode.cn id=40 lang=python3
#
# [40] 组合总和 II
#

# @lc code=start
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates)<=0:
            return []
        candidates.sort()
        self.res = []
        self.dfs(candidates,[],target,0)
        return self.res
    def dfs(self,candidates,sublist,target,index):
        if target == 0:
            self.res.append(sublist)
            return
        if target < 0:
            return
        for i in range(index,len(candidates)):  # 从当前index开始遍历
            if i != index and candidates[i] == candidates[i-1]: # 保证每个数字只使用一次
                continue
            self.dfs(candidates,sublist+[candidates[i]],target-candidates[i],i+1)
# @lc code=end

