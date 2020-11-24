#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            if(target<=matrix[i][-1] and target>=matrix[i][0]):return target in matrix[i]
            if target<matrix[i][0]:break
        return False
                



# @lc code=end

