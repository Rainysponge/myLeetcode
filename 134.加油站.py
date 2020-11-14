#
# @lc app=leetcode.cn id=134 lang=python3
#
# [134] 加油站
#

# @lc code=start
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
       
        m = len(gas)
        if m==1 and gas[0] - cost[0]>=0:
            return 0

        for i in range(m):
            gas_sum = gas[i] - cost[i]
            if gas_sum < 0 :
                continue
            step = 1
            while gas_sum >= 0:
                station = (i + step) % m
                gas_sum += gas[station] - cost[station]
                if gas_sum < 0:
                    break
                step += 1
                if step == m:
                    return i
        return -1
        # begin,subsum,sum,i = 0,0,0,0
        # while i < len(gas):
        #     sum += gas[i] - cost[i]
        #     subsum += gas[i] - cost[i]
        #     if subsum < 0:
        #         subsum,begin = 0,i + 1
        #     i += 1
        # if sum < 0:
        #     return -1
        # else:
        #     return begin



# @lc code=end

