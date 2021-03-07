#
# @lc app=leetcode.cn id=350 lang=python3
#
# [350] 两个数组的交集 II
#

# @lc code=start
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # hash
        res = []
        nums1_dic = collections.defaultdict(int)
        for i in range(len(nums1)):
            nums1_dic[nums1[i]] += 1
        for i in range(len(nums2)):
            if nums1_dic[nums2[i]]:
                res.append(nums2[i])
                nums1_dic[nums2[i]] -= 1
        return res
        
# @lc code=end

