#
# @lc app=leetcode.cn id=38 lang=python3
#
# [38] 外观数列
#

# @lc code=start
class Solution:
    def countAndSay(self, n: int) -> str:
        res = '1'
        for i in range(2, n+1):
            pre = res
            res = ''
            p = 0  # 索引
            flag = pre[p]
            count = 0  # 记录个数
            while p<len(pre):
                if flag == pre[p]:
                    count += 1
                    p += 1
                else:
                    res = res + str(count) + str(flag)
                    flag = pre[p]
                    p += 1
                    count = 1
            res+=str(count)+pre[p-1]
        return res

# @lc code=end

