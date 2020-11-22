#
# @lc app=leetcode.cn id=407 lang=python3
#
# [407] 接雨水 II
#

# @lc code=start
class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        # 有点疑惑
        if not heightMap:
            return 0

        # 从外圈依次往内部延伸
        heap = []
        m, n = len(heightMap), len(heightMap[0])
        visited = set()

        for i in range(m):
            heapq.heappush(heap, (heightMap[i][0], (i,0)))
            heapq.heappush(heap, (heightMap[i][n-1], (i,n-1)))
            visited.add((i,0))
            visited.add((i,n-1))
        for j in range(n):
            heapq.heappush(heap, (heightMap[0][j], (0,j)))
            heapq.heappush(heap, (heightMap[m-1][j], (m-1,j)))
            visited.add((0,j))
            visited.add((m-1,j))

        dire = [(0,1), (0,-1), (1,0), (-1,0)]
        res = 0
        while len(visited) < m*n:
            i,j = heapq.heappop(heap)[1]
            for di,dj in dire:
                if i+di >= 0 and i+di < m and j+dj >= 0 and j+dj < n and (i+di,j+dj) not in visited:
                    # 判断在边界内，且尚未访问
                    if heightMap[i+di][j+dj] <= heightMap[i][j]:
                        res += heightMap[i][j] - heightMap[i+di][j+dj]
                        heightMap[i+di][j+dj] = heightMap[i][j]
                    else:
                        pass
                    visited.add((i+di,j+dj))
                    heapq.heappush(heap,(heightMap[i+di][j+dj],(i+di,j+dj)))
        return res


# 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/fei-chang-qing-xi-de-pythonjie-fa-by-user2198v/

# @lc code=end

