#
# @lc app=leetcode.cn id=435 lang=python3
#
# [435] 无重叠区间
#

# @lc code=start
class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals = sorted(intervals)
        # start = intervals[0][0]
        end = intervals[0][1]
        res = 0
        for i in range(1, len(intervals)):
            end = min(end, intervals[i][1])
            if end > intervals[i][0]:
                res += 1
            else:
                end = intervals[i][1]
        return res
       
                
# @lc code=end

