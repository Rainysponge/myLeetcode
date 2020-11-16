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
        end = intervals[0][1]  # 记录第一个结尾
        res = 0
        m = len(intervals)
        for i in range(1, m):
            end = min(end, intervals[i][1])
            if end > intervals[i][0]:
                res += 1
            else:
                end = intervals[i][1]
        
        return res
# @lc code=end

