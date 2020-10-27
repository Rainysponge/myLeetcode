#
# @lc app=leetcode.cn id=85 lang=python3
#
# [85] 最大矩形
#

# @lc code=start
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        # 参考84的解法, 从上往下看成最大连续的柱子求解
        def maxS(List):
            res = 0
            i = 0
            stack = []
            List.append(0)
            while i < len(List):
                if len(stack) == 0 or List[stack[-1]] <= List[i]:
                    stack.append(i)
                    i += 1
                else:
                    k = stack.pop()
                    if len(stack) == 0:
                        res = max(res, i*List[k])
                    else:
                        res = max(res,(i-stack[-1]-1)*List[k])
            return res
        if not matrix or not matrix[0] :
            return 0
        m = len(matrix)
        n = len(matrix[0])
        
        ListT = [0 for _ in range(n)]
        res = 0
        for i in range(m):
            for j in range(n):
                ListT[j]  = ListT[j] + 1 if matrix[i][j] == '1' else 0
            res = max(maxS(ListT), res)
        return res
# @lc code=end

