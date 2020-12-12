#
# @lc app=leetcode.cn id=131 lang=python3
#
# [131] 分割回文串
#

# @lc code=start
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        # 32/32 cases passed (136 ms)
        # Your runtime beats 6.08 % of python3 submissions
        # Your memory usage beats 5.05 % of python3 submissions (27.9 MB)
        self.isPartition = lambda s : s == s[::-1]
        res = []
        self.dfs(s, res, [])
        return res

    def dfs(self, s, res, path):
        if not s:
            res.append(path)
            return
        for i in range(1, len(s)+1):
            if self.isPartition(s[:i]):
                self.dfs(s[i:], res, path+[s[:i]])

# @lc code=end

