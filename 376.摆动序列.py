#
# @lc app=leetcode.cn id=376 lang=python3
#
# [376] 摆动序列
#

# @lc code=start
class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        
        # n = len(nums)
        # if n <= 1:
        #     return n
        # inc, dec = [1] * n, [1] * n
        # for x in range(n):
        #     for y in range(x):
        #         if nums[x] > nums[y]:
        #             inc[x] = max(inc[x], dec[y] + 1)
        #         elif nums[x] < nums[y]:
        #             dec[x] = max(dec[x], inc[y] + 1)
        # return max(inc[-1], dec[-1])
        n = len(nums)
        if n <= 1:
            return n
        inc, dec = 1, 1
        for x in range(1, n):
            if nums[x] > nums[x - 1]:
                inc = dec + 1
            elif nums[x] < nums[x - 1]:
                dec = inc + 1
        return max(inc, dec)
# ————————————————
# 版权声明：本文为CSDN博主「负雪明烛」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
# 原文链接：https://blog.csdn.net/fuxuemingzhu/article/details/82902655








        
# @lc code=end

