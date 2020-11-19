#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        # ans = []
        # def backtrack(S = '', left = 0, right = 0):
        #     if len(S) == 2 * n:
        #         ans.append(S)
        #         return
        #     if left < n:
        #         backtrack(S+'(', left+1, right)
        #     if right < left:
        #         backtrack(S+')', left, right+1)

        # backtrack()
        # return ans
        res = []
        self.backtrack('', 0, 0, n, res)
        return res


    def backtrack(self, S, left, right, n, res):
        if len(S) == 2 * n:
            res.append(S)
            return
        if left < n:
            self.backtrack(S+'(', left+1, right, n, res)
        if left > right:
            self.backtrack(S+')', left, right+1, n, res)
# @lc code=end

