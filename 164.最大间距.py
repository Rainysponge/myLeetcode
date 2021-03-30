#
# @lc app=leetcode.cn id=164 lang=python3
#
# [164] 最大间距
#

# @lc code=start
class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        # if len(nums) < 2:
        #     return 0
        
        # Max = max(nums)
        # res = -1
        # hashTable = [-1 for i in range(Max+1)]
        # for item in nums:
        #     hashTable[item] = item
        # tmp = 1
        # flag = False
        # for i in range(Max+1):
        #     if hashTable[i] == -1 and flag:
        #         tmp += 1
        #         continue
            
        #     res = max(res, tmp)
        #     tmp = 1
        #     flag = True
        # return res
    
        if len(nums) < 2:
            return 0
        min_val, max_val = min(nums), max(nums)
        if min_val == max_val:
            return 0
        
        n = len(nums) + 1 # 桶的个数
        step = (max_val - min_val) // n
        
        exist = [0 for _ in range(n + 1)]  # 表示桶是否为空
        max_num = [0 for _ in range(n + 1)]  # 表示桶里元素的最大值
        min_num = [0 for _ in range(n + 1)]  # 表示桶离元素的最小值
        
        for num in nums: #把所有的数入桶
            idx = self.findBucketIndex(num, min_val, max_val, n) 
            max_num[idx] = num if not exist[idx] else max(num, max_num[idx])
            min_num[idx] = num if not exist[idx] else min(num, min_num[idx])
            exist[idx] = 1
        res = 0
        pre = max_num[0]
        for i in range(1, n + 1):
            if exist[i]:
                res = max(res, min_num[i] - pre)
                pre = max_num[i]
        return res
                        
    def findBucketIndex(self, num, min_val, max_val, n):
        return int((num - min_val) * n / (max_val - min_val))
    



# @lc code=end

