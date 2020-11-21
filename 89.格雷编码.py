#
# @lc app=leetcode.cn id=89 lang=python3
#
# [89] 格雷编码
#

# @lc code=start
class Solution:
    def grayCode(self, n: int) -> List[int]:
        if n < 1:
           return [0]
        if n == 1:
            return [0, 1]
        # n位的与n-1位的格雷码是有关系的，
        # 前半部分与n-1位的相同。
        # 后半部分的由对称的前面那部分加上2^(n-1)。
        
        res = self.grayCode(n-1)
        
        digit = pow(2, n-1)
        for i in range(digit-1, -1, -1):
            res.append(res[i] + digit)
        
        return res

# @lc code=end

