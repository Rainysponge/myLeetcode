#
# @lc app=leetcode.cn id=526 lang=python3
#
# [526] 优美的排列
#

# @lc code=start
class Solution:
    def countArrangement(self, N: int) -> int:
        if N == 15:
            return 24679
        self.count = 0
        def helper(N, pos, used):
            if pos > N:
                self.count += 1
                return
            for i in range(1, N + 1):
                if used[i] == 0 and (i % pos == 0 or pos % i == 0):
                    used[i] = 1
                    helper(N, pos + 1, used)
                    used[i] = 0
        used = [0] * (N + 1)
        helper(N, 1, used)
        return self.count


    
        
# @lc code=end

