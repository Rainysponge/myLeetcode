#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # res = []
        # def sub_set(start, num):
        #     res.append(num)
        #     for i in range(start, len(nums)):
        #         sub_set(i+1, num+[nums[i]])
        # sub_set(0,[])
        # return res
        
        # 依次遍历nums列表中的数字 双重循环 
        # 第二重遍历res列表中的元素 
        # 给每个元素中添加nums中的数字 
        # 下面举个例子 比如按照样例中[1,2,3]
        #         初始化 [ [ ] ]
        # 第一次大循环完 [ [ ], [1] ]
        # 第二次大循环完 [ [ ], [1], [2], [1,2] ]
        # 第三次大循环完 [ [ ], [1], [2], [3], [1,3], [1,2], [2,3], [1,2,3] ]
        #         res = [[]]
        for num in nums:
            for temp in res[:]:
                x = temp[:]
                x.append(num)
                res.append(x)
        return res

# @lc code=end

