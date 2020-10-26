#
# @lc app=leetcode.cn id=18 lang=python3
#
# [18] 四数之和
#

# @lc code=start
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        #类似于两数之和和三数之和，用哈希表来求解，会使用较多内存
        result, Dict = set(), {}
        nums_len = len(nums)
        nums.sort()
        for i in range(nums_len-1):
            for j in range(i+1,nums_len):
                key_sum = nums[i] + nums[j]
                if not key_sum in Dict.keys():
                    Dict[key_sum] = [(i,j)]
                else:
                    Dict[key_sum].append((i,j))
        
        for i in range(nums_len-1):
            for j in range(i+1,nums_len):
                delta = target - nums[i] - nums[j]
                if delta in Dict.keys():
                    for tmp in Dict[delta]:
                        if tmp[0]>j:
                            result.add((nums[i], nums[j], nums[tmp[0]], \
                                nums[tmp[1]]))
        return [list(i) for i in result]



# @lc code=end

