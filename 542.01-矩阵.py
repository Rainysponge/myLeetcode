#
# @lc app=leetcode.cn id=542 lang=python3
#
# [542] 01 矩阵
#

# @lc code=start
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        # m, n = len(matrix), len(matrix[0])
        # dist = [[0] * n for _ in range(m)]  # 建了一个和matrix一样的0矩阵
        # zeroes_pos = [(i, j) for i in range(m) for j in range(n) if matrix[i][j] == 0] 
        # # 将matrix中所有的 0 的位置添加进初始队列中
        # q = collections.deque(zeroes_pos)  # 列表转为 双端队列
        # seen = set(zeroes_pos) # 0的位置当作已经走过的节点，set可以防止重复

        # # 广度优先搜索
        # while q:
        #     i, j = q.popleft() # 从左边弹出
        #     for ni, nj in [(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)]:
        #         if 0 <= ni < m and 0 <= nj < n and (ni, nj) not in seen:  
        #         # 因为有这个seen限制，所以能保证计算的1的层数是最小的
        #         # 当之后再有0起点遍历到这个1节点的时候，它已经因为之前的0起点被存入
        #         # seen了，所以不会被再次遍历
        #             dist[ni][nj] = dist[i][j] + 1
        #             q.append((ni, nj))
        #             seen.add((ni, nj))
        
        # return dist
        # 从0开始向外部搜索

        m, n = len(matrix), len(matrix[0])
        dist = [[0 for _ in range(n)] for _ in range(m)]
        zeroP = [(i, j) for i in range(m) for j in range(n) if matrix[i][j] == 0]
        q = collections.deque(zeroP)
        seen = set(zeroP)
        while q:
            i, j = q.popleft()
            for ni, nj in [(i-1, j), (i+1, j), (i, j+1), (i, j-1)]:
                if 0<=ni<m and 0<=nj<n and (ni, nj) not in seen:
                    dist[ni][nj] = dist[i][j] + 1
                    q.append((ni, nj))
                    seen.add((ni, nj))

        return dist
        

        
# @lc code=end

