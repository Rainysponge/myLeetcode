#
# @lc app=leetcode.cn id=118 lang=python3
#
# [118] 杨辉三角
#

# @lc code=start
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        res = [[1]]
        for i in range(1, numRows):
            tmp = []
            for j in range(i+1):
                
                
                if j == 0 or j == i:
                    tmp.append(1)
                else:
                    t = res[i-1][j] + res[i-1][j-1]
                    tmp.append(t)
            res.append(tmp)

        return res

                
# @lc code=end

