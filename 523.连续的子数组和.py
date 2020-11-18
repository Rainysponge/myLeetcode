#
# @lc app=leetcode.cn id=523 lang=python3
#
# [523] 连续的子数组和
#

# @lc code=start
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        # 前缀和
        # sum[i:j] = sum[:j] - sum[:i]
        # 可以被k整除的连续数组，只要保证sum[:j]
        # 和sum[:i]的对k的余数相等即可。
        if len(nums) < 2: return False
        dp, cur = {0: -1}, 0
        for idx, num in enumerate(nums):
            cur += num
            if k != 0: cur %= k
            pre = dp.setdefault(cur, idx)
            if idx - pre > 1: return True
        return False
# @lc code=end

