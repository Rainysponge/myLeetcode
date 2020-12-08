#
# @lc app=leetcode.cn id=442 lang=python3
#
# [442] 数组中重复的数据
#

# @lc code=start
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        # hash T:64.15%  M:6.61%
        # hash_table = {}
        # res = []
        # for i in range(len(nums)):
        #     if nums[i] not in hash_table:
        #         hash_table[nums[i]] = 1
        #     else:
        #         hash_table[nums[i]] += 1
        # for key in hash_table:
        #     if hash_table[key] > 1:
        #         res.append(key)
        # return res
        # 关键条件
        # 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 
        # 其中有些元素出现两次而其他元素出现一次。
        # T:88.09%  M:27.59%
        returnlist=[]
        for x in nums:
            if nums[abs(x)-1]<0:
                returnlist.append(abs(x))
            else:
                nums[abs(x)-1]*=-1
        return returnlist
# @lc code=end

