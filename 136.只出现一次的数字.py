#
# @lc app=leetcode.cn id=136 lang=python3
#
# [136] 只出现一次的数字
#

# @lc code=start
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        # hash暴力 AC
        # hash_table = {}
        # for i in nums:
        #     if i not in hash_table:
        #         hash_table[i] = 1
        #     else:
        #         hash_table[i] = 2
        # for i in hash_table:
        #     if hash_table[i] == 1:
        #         return i
        # 线性时间复杂度，不使用额外空间
        # 通过异或法，自己异或自己为0
        # 6666
        res = 0
        for i in nums:
            res ^= i
        return res



# @lc code=end

