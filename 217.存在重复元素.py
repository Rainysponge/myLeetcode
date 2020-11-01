#
# @lc app=leetcode.cn id=217 lang=python3
#
# [217] 存在重复元素
#

# @lc code=start
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # 哈希表法
        m = len(nums)
        if m == 0 or m == 1:
            return False
        hash_table = {}
        for i in range(m):
            if nums[i] not in hash_table:
                hash_table[nums[i]] = 1
            else:
                return True
        return False
        



# @lc code=end

