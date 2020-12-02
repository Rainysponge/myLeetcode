#
# @lc app=leetcode.cn id=679 lang=python3
#
# [679] 24 点游戏
#

# @lc code=start
class Solution:
    def judgePoint24(self, nums: List[int]) -> bool:
        def helper(nums):
            if not nums:
                return False
            if len(nums) == 1:
                return abs(nums[0] - 24) < 0.000001

            for i in range(len(nums)):
                for j in range(len(nums)):
                    # 不能选取同个位置的数字
                    if i == j:
                        continue
                    # 标记是否最终结果等于 24
                    status = False

                    x = nums[i]
                    y = nums[j]

                    # 选取 i,j 对应位置的数字进行计算，其他数字放入数组后续计算
                    new_nums = [nums[k] for k in range(len(nums)) if( k!=i and k!=j)]
                    # 执行四项运算，加法乘法符合交换律，a + b = b + a, a*b=b*a，可跳过其中一项
                    # 这里默认 i > j 部分跳过，or 短路语句
                    # 加法，乘法
                    if i < j:
                        status = status or helper(new_nums + [x+y])
                        status = status or helper(new_nums + [x*y])
                    # 减法
                    status = status or helper(new_nums + [x-y])
                    # 除法
                    if abs(y) > 0.000001:
                        status = status or helper(new_nums + [x/y])

                    if status:
                        return True
            return False
        return helper(nums)
# @lc code=end

