#
# @lc app=leetcode.cn id=223 lang=python3
#
# [223] 矩形面积
#

# @lc code=start
class Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        if min(C, G) - max(A, E) < 0 or min(D, H) - max(B, F) < 0:
            S_overlap = 0
        else:
            S_overlap = (min(C, G) - max(A, E)) * (min(D, H) - max(B, F))
        S_first_square = (D - B) * (C - A)
        S_second_square = (H - F) * (G - E)
        return S_second_square + S_first_square - S_overlap
 # @lc code=end

