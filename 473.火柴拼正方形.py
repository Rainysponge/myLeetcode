#
# @lc app=leetcode.cn id=473 lang=python3
#
# [473] 火柴拼正方形
#

# @lc code=start
class Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if not nums:
            return False
        L = len(nums)
        perimeter = sum(nums)
        possible_side =  perimeter // 4
        if possible_side * 4 != perimeter:
            return False

        nums.sort(reverse=True)
        sums = [0 for _ in range(4)]

        def dfs(index):
            if index == L:
                # If 3 equal sides were formed, 4th will be the same as these three and answer should be True in that case.
                return sums[0] == sums[1] == sums[2] == possible_side

            
            for i in range(4):
                # If this matchstick can fir in the space left for the current side
                if sums[i] + nums[index] <= possible_side:
                    sums[i] += nums[index]
                    if dfs(index + 1):
                        return True
                    sums[i] -= nums[index]
            return False        
        return dfs(0)

# 作者：LeetCode
# 链接：https://leetcode-cn.com/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

# @lc code=end

