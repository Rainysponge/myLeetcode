#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals)
        m = len(intervals)
        if not intervals:
            return []
        res = []
        tmp = 0
        for i in range(m-1):
            if intervals[tmp][1] >= intervals[i+1][0]:
                if intervals[tmp][1] <= intervals[i+1][1]:
                    intervals[tmp] = [intervals[tmp][0], intervals[i+1][1]]
                else:
                    continue
            else:
                res.append(intervals[tmp])
                tmp = i+1
        res.append(intervals[tmp])
        return res

# @lc code=end

