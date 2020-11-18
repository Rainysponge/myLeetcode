#
# @lc app=leetcode.cn id=73 lang=python3
#
# [73] 矩阵置零
#

# @lc code=start
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # m = len(matrix)
        # n = len(matrix[0])
        # dist = []
        # for i in range(m):
        #     for j in range(n):
        #         if matrix[i][j] == 0:
        #             dist.append((i,j))
        
        # while len(dist)>0:
        #     i, j = dist.pop()
        #     for k in range(m):
        #         matrix[k][j] = 0
        #     for k in range(n):
        #         matrix[i][k] = 0
        # 把行列置零记录的list的功能，
        # 直接放到原来矩阵的第一行和第一列，
        # 在遍历元素的时候把需要置零的行在
        # 第一列对应位置置零，需要置零的列
        # 在第一行对应位置置零，后续再根据
        # 第一行和第一列的标记补零。
        # 这里存在的问题是，第一行和第一列本
        # 来存在的零和后来补上的零会混淆，原来
        # 的零具备一个功能是把第一行和第一列
        # 置零，所以在一开始的时候，需要遍历
        # 第一行和第一列，确定是否有零。然后
        # 在最后对第一行和第一列进行置零操作。
        rows=len(matrix)
        cols=len(matrix[0])
        row_zero=False
        col_zero=False
        for i in matrix[0]:
            if i==0:
                row_zero=True
        for j in range(rows):
            if matrix[j][0]==0:
                col_zero=True

        for row in range(1,rows):
            for col in range(1,cols):
                if matrix[row][col]==0:
                    matrix[row][0]=0
                    matrix[0][col]=0

        for row in range(1,rows):
            if matrix[row][0]==0:
                matrix[row]=[0]*cols

        for col in range(1,cols):
            if matrix[0][col]==0:
                for row in range(1,rows):
                    matrix[row][col]=0

        if row_zero:
            matrix[0]=[0]*cols

        if col_zero:
            for row in range(rows):
                matrix[row][0]=0



# @lc code=end

