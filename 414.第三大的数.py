#
# @lc app=leetcode.cn id=414 lang=python3
#
# [414] 第三大的数
#

# @lc code=start
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        res = [float("-inf")] * 3
        for i in nums:
            if i in res:
                continue
            if i > res[0]:
                res = [i,res[0],res[1]]
            elif i > res[1]:
                res = [res[0],i,res[1]]
            elif i > res[2]:
                res = [res[0],res[1],i]
            print(res)
        return res[-1] if res[2] != float("-inf") else res[0]
            

        
        
# @lc code=end

