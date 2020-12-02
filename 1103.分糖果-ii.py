#
# @lc app=leetcode.cn id=1103 lang=python3
#
# [1103] 分糖果 II
#

# @lc code=start
class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        
        res = [0 for _ in range(num_people)]
        t = 1
        p = 0
        while candies:
            if candies >=t:
                res[p%num_people] += t
                candies -= t
            else:
                res[p%num_people] += candies
                candies = 0
            t += 1
            p += 1
        return res
            
        
# @lc code=end

