#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        track = []
        ret = []
        self.backtracking(n,k,1,track,ret)
        return ret
    
    def backtracking(self, n, k, start, track, ret):
        if len(track) == k:
            ret.append(track[:])
            # track = []
        for i in range(start, n+1):
            track.append(i)
            self.backtracking(n, k, i+1, track, ret)
            track.pop()
# @lc code=end

