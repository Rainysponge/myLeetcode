#
# @lc app=leetcode.cn id=228 lang=python3
#
# [228] 汇总区间
#

# @lc code=start
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        
        m = len(nums)
        if m == 0:
            return []
        if m == 1:
            return[str(nums[0])]
        res = []
        stack = []
        for i in range(m):
            if not stack or nums[i] == stack[-1]+1:
                stack.append(nums[i])
            else:
                if len(stack) == 1:
                    res.append(str(stack[0]))
                else:
                    res.append("{}->{}".format(stack[0],stack[-1]))
                stack = []
                stack.append(nums[i])
        if stack:
            if len(stack) == 1:
                res.append(str(stack[0]))
            else:
                res.append("{}->{}".format(stack[0],stack[-1]))
        return res
                
        

        
# @lc code=end

