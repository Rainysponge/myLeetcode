#
# @lc app=leetcode.cn id=373 lang=python3
#
# [373] 查找和最小的K对数字
#

# @lc code=start
class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        heap = []
        if not nums1 or not nums2:
            return []
        m, n = len(nums1), len(nums2)
        for i in range(m):
            for j in range(n):
                heap.append([nums1[i], nums2[j]])
        return sorted(heap, key = sum)[:k]
        
# @lc code=end

