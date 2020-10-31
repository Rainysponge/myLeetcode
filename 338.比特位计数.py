#
# @lc app=leetcode.cn id=338 lang=python3
#
# [338] 比特位计数
#

# @lc code=start
class Solution:
    def countBits(self, num: int) -> List[int]: 
        # 暴力
        # res = []
        # for i in range(num+1):
        #     tmp = 0
        #     j = i
        #     while j>0:
        #         if j % 2 == 1:
        #             tmp += 1
        #         j = j // 2
        #     res.append(tmp)
        # return res
        # [0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4]

        # 考虑二进制数的规律。
        # [000,001,010,011,100,101,110,111]，
        # 分别对应[0,1,2,3,4,5,6,7]。
        # 从上述二进制数可以看出来，4-7的二进制
        # 数既是对0-3的二进制数的最高位从0变成1，
        # 也就是说后面的二进制数都是在之前所有二
        # 进制的最高位加一位1。

        List1 = [0]
        while(len(List1)<=num):
            List2 = [i+1 for i in List1]
            List1 += List2

        return List1[:num+1]
# @lc code=end

