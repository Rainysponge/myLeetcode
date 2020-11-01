#
# @lc app=leetcode.cn id=45 lang=python3
#
# [45] 跳跃游戏 II
#

# @lc code=start
class Solution:
    def jump(self, nums: List[int]) -> int:
        # m = len(nums)
        # if m <= 1:
        #     return 0
        # tmp = nums[0]
        # point = 0
        # res = 1
        # while (tmp + point) < m-1:
        #     if nums[point] + nums[point + tmp] >= m-1:
        #         return res + 1
        #     nextp = point
            
        #     Max = 0
        #     for i in range(point+1,point+1+tmp):
        #         if Max <= nums[i]:
        #             nextp = i
        #             Max = nums[i]
        #     point = nextp
        #     tmp = nums[point]
        #     res += 1
        #     # if tmp
        # return res
        # [9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5]
        # 80/95 passed
        reach = 0
        cur = 0
        N = len(nums)
        count = 0
        pos = 0
        while cur < N - 1:
            count += 1
            pre = cur
            while pos <= pre:
                cur = max(cur, pos + nums[pos])
                pos += 1
        return count


# @lc code=end

