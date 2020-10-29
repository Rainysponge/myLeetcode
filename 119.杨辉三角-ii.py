#
# @lc app=leetcode.cn id=119 lang=python3
#
# [119] 杨辉三角 II
#

# @lc code=start
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        # if rowIndex == 0:
        #     return [1]
        # res = [[1]]
        # for i in range(1, rowIndex+1):
        #     tmp = []
        #     for j in range(i+1):
                
                
        #         if j == 0 or j == i:
        #             tmp.append(1)
        #         else:
        #             t = res[i-1][j] + res[i-1][j-1]
        #             tmp.append(t)
        #     res.append(tmp)

        # return res[rowIndex]
        # 不满足空间复杂度
        #  以第四行为例 14641 可看作
        #    1 3 3 1 0
        #  + 0 1 3 3 1
        # ——————————————
        #    1 4 6 4 1   
        
        res = [1]
        for i in range(rowIndex):
            res = [x+y for x,y in zip([0]+res,res+[0])]
        return res


# @lc code=end

