#
# @lc app=leetcode.cn id=134 lang=python3
#
# [134] 加油站
#

# @lc code=start
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start = 0
        gas_sum = 0
        i = 0
        Sum = 0
        while i<len(gas):
            Sum += gas[i] - cost[i]
            gas_sum += gas[i] - cost[i]
            if Sum < 0:
                Sum, start = 0, i+1
                # 当i处Sum<0则此处当起点也是不行的，
                # 所以从i+1开始
            i += 1
        if gas_sum<0:
            return -1
        return start











# @lc code=end

