#
# @lc app=leetcode.cn id=84 lang=python3
#
# [84] 柱状图中最大的矩形
#

# @lc code=start
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # 暴力如下，在case95中出现Time Limit Exceeded 
        # res = 0
        # heights_len = len(heights)
        # for i in range(heights_len):
        #     min_h = heights[i]
        #     for j in range(i, heights_len):
        #         min_h = min(min_h, heights[j])
        #         res = max(res, min_h*(j-i+1))
        # return res

        # 递增栈————就是栈中只存放递增序列。
        stack = []  # 存放指针或者说是位置
        # stack中存放位置信息，不改变heights
        heights.append(0)
        i = 0
        res = 0
        while i < len(heights):
            if len(stack) == 0 or heights[stack[-1]] <= heights[i]:
                stack.append(i)
                i += 1
            else:
                k = stack.pop()
                if len(stack) == 0:
                    res = max(res, i*heights[k])
                else:
                    res = max(res, (i - stack[-1] - 1)*heights[k])
                    # 此时i指向此时最大数的后一个数，所以是i - stack[-1] - 1
        return res



# @lc code=end

