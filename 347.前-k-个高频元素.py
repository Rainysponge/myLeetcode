#
# @lc app=leetcode.cn id=347 lang=python3
#
# [347] 前 K 个高频元素
#

# @lc code=start
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hash_table = {}
        for num in nums:
            if num not in hash_table:
                hash_table[num] = 1
            else:
                hash_table[num] += 1
        res = sorted(hash_table.items(), key=lambda x: x[1], reverse=True)
        return list( item[0] for item in res[:k])
# @lc code=end

