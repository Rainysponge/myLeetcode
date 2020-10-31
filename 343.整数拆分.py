#
# @lc app=leetcode.cn id=343 lang=python
#
# [343] 整数拆分
#

# @lc code=start
class Solution(object):
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        # 百度的数学方法，需要求导
        # 从5开始，数字都需要先拆出所有的3，一直拆到剩下一个
        # 数为2或者4，因为剩4就不用再拆了，拆成两个2和不拆没
        # 有意义，而且4不能拆出一个3剩一个1，这样会比拆成2+2
        # 的乘积小。那么这样我们就可以写代码了，先预处理n为2
        # 和3的情况，然后先将结果res初始化为1，然后当n大于4
        # 开始循环，我们结果自乘3，n自减3，根据之前的分析，
        # 当跳出循环时，n只能是2或者4，再乘以res返回即可。
        # 或者参考
        # https://blog.csdn.net/weixin_45642918/article/details/107700286
        # if n <= 3:
        #     return n - 1
        # a = n//3
        # b = n % 3
        # if b == 0:
        #     return 3**a
        # if b == 1:
        #     return 3**(a-1)*4
        # if b == 2:
        #     return 3**a*2
        
        # dp 
        dp = [0, 0, 1, 2, 4, 6, 9]
        if n >= 7:
            for i in range(7, n + 1):
                dp.append(dp[i - 3] * 3)
        return dp[n]
        # 总的来说这是一道数学题 __+__
        

# @lc code=end

