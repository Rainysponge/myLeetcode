#
# @lc app=leetcode.cn id=316 lang=python3
#
# [316] 去除重复字母
#

# @lc code=start
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        visited = set()
        last_index = {c: i for i, c in enumerate(s)}
        stack = []
        for index, value in enumerate(s):
            if value not in visited:
                while stack and value < stack[-1] and index < last_index[stack[-1]]:
                    visited.discard(stack.pop())
                    # index < last_index[stack[-1]]查看后面是否还会出现

                visited.add(value)
                stack.append(value)
        return ''.join(stack)


# @lc code=end

