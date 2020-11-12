#
# @lc app=leetcode.cn id=457 lang=python3
#
# [457] 环形数组循环
#

# @lc code=start
class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        N, self.nums = len(nums), nums
        for i in range(N):
            slow = i
            fast = self.nextpos(slow)
            while nums[fast] * nums[i] > 0 and nums[self.nextpos(fast)] * nums[i] > 0:
                if fast == slow:
                    if slow == self.nextpos(slow):
                        break
                    return True
                slow = self.nextpos(slow)
                fast = self.nextpos(self.nextpos(fast))
        return False
    
    def nextpos(self, index):
        N = len(self.nums)
        return (index + self.nums[index] ) % N
        
# @lc code=end

