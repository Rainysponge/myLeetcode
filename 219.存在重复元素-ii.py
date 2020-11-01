#
# @lc app=leetcode.cn id=219 lang=python3
#
# [219] 存在重复元素 II
#

# @lc code=start
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # 哈希表+贪心
        m = len(nums)
        if m == 0 or m == 1:
            return False
        hash_table = {}
        for i in range(m):
            if nums[i] not in hash_table:
                hash_table[nums[i]] = i
            else:
                tmp = i - hash_table[nums[i]]
                if tmp <= k:
                    return True
                else:
                    hash_table[nums[i]] = i
        return False
# @lc code=end

