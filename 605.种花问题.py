#
# @lc app=leetcode.cn id=605 lang=python3
#
# [605] 种花问题
#

# @lc code=start
class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        # 来回遍历即可
        m = len(flowerbed)
        if flowerbed == [1]:
            if n == 0:
                return True
            else:
                return False
        if flowerbed == [0]:
            if n <= 1:
                return True
            else:
                return False

        res = [True for _ in range(m)]
        for i in range(1, m):
            if flowerbed[i] == 1 or flowerbed[i-1] == 1 or res[i-1] == True:
                res[i] = False
        for i in range(m-2, -1,-1):
            if flowerbed[i] == 1 or flowerbed[i+1] == 1:
                res[i] = False
        res = sum(res)
        return res >= n
        
# @lc code=end

