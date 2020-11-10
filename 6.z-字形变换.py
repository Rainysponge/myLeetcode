#
# @lc app=leetcode.cn id=6 lang=python3
#
# [6] Z 字形变换
#

# @lc code=start
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # 1157/1157 cases passed (2072 ms)
        # Your runtime beats 5 % of python3 submissions
        # Your memory usage beats 5 % of python3 submissions (20.6 MB)
        # s_len = len(s)
        # if s_len <= numRows or numRows == 1:
        #     return s
        # ones = 2 * numRows - 2
        # numCols = (s_len//ones+1)*(numRows-1)
        # graph = [['*' for _ in range(numCols)]for _ in range(numRows)]
        # point = 0
        # for j in range(numCols):
        #     if point >= s_len:
        #         break
        #     for k in range(numRows):
        #         if point >= s_len:
        #             break
        #         if j % (numRows-1) == 0:
        #             graph[k][j] = s[point]
        #             point += 1
                
        #         else:
        #             if (j+k) % (numRows-1) == 0:
        #                 graph[k][j] = s[point]
        #                 point += 1
        #             else:
        #                 continue
        # res = ''
        # for i in range(numRows):
        #     for j in range(numCols):
        #         if graph[i][j] == '*':
        #             continue
        #         else:
        #             res += graph[i][j]
        # return res
        # 每次循环头尾都比中间少加一次
        if numRows==1 or numRows>=len(s) :return s
        r,j,k=['']*numRows,0,1
        for i in s:
            r[j]+=i
            j+=k
            if j==0 or j==numRows-1 : k=-k
        return "".join(r)



# @lc code=end

