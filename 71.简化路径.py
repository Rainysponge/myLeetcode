#
# @lc app=leetcode.cn id=71 lang=python3
#
# [71] 简化路径
#

# @lc code=start
class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = collections.deque()
        pathList = path.split('/')
        for item in pathList:
            if item == '..':
                if stack:
                    stack.pop()
                continue
            if not item or item == '.':
                continue
            stack.append(item)
        return '/' + '/'.join(stack)
            
        
# @lc code=end

