#
# @lc app=leetcode.cn id=57 lang=python3
#
# [57] 插入区间
#

# @lc code=start
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # intervals.append(newInterval)
        # intervals, index = sorted(intervals), 1
        # while index < len(intervals):
        #     if intervals[index - 1][1] >= intervals[index][0]:
        #         intervals[index - 1][1] = max(intervals[index - 1][1], intervals[index][1])
        #         intervals.pop(index)
        #     else:
        #         index += 1
        # return intervals

        left, right = newInterval
        ans, placed = [], False
        for i, v in enumerate(intervals):
            if v[0] > right:
                if not placed:
                    ans.append([left, right])
                    placed = True
                ans.append(v)
            elif v[1] < left:
                ans.append(v)
            else:
                left = min(left, v[0])
                right = max(right, v[1])
        if not placed:
            ans.append([left, right])
        return ans
# ————————————————
# 版权声明：本文为CSDN博主「乐观点摸摸头」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
# 原文链接：https://blog.csdn.net/qq_33511971/article/details/109923428






# @lc code=end

