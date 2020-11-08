#
# @lc app=leetcode.cn id=413 lang=python3
#
# [413] 等差数列划分
#

# @lc code=start
class Solution:
    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        tmp, num = 0, 0
        Max = 0
        for i in range(2, len(A)):
            if A[i-2] - A[i-1] == A[i-1] - A[i]:
                tmp += 1
                num += tmp
            
            else:
                tmp = 0
                # 当一个等差数列结束后归 0
                Max = max(Max, num)
        Max = max(Max, num)
        return Max
# @lc code=end

