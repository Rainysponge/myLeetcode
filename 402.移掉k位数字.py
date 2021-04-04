#
# @lc app=leetcode.cn id=402 lang=python3
#
# [402] 移掉K位数字
#

# @lc code=start
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        # is_active = [True for _ in range(len(num))]
        # tmp = [int(num) for _ in range(len(num))]
        # Min = int(num)
        # index = 0
        # for i in range(k):
        #     if int(tmp[:i]+tmp[-1:-i:-1]) < Min:
        #         index = i
        out=[]
        for d in num:
            while k and out and out[-1]>d:
                out.pop()
                k-=1
            out.append(d)
        return ''.join(out[:-k or None]).lstrip('0') or '0'



        # def dp(num):
        #     dp = [int('inf') for i in range(len(num))]
        #     for i in range(len(num)):
        #         dp[i] = min()
        
# @lc code=end

