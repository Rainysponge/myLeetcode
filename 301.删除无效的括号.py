#
# @lc app=leetcode.cn id=301 lang=python3
#
# [301] 删除无效的括号
#

# @lc code=start
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def isValid(s):
            count = 0
            for char in s:
                if char == '(':
                    count += 1
                if char == ')':
                    count -= 1
                if count < 0:
                    return False  # ())))
            return count == 0
 
        def dfs(s, start, l, r):
            if l == 0 and r == 0:
                if isValid(s):
                    self.ans.append(s)
                return
            for i in range(start, len(s)):
                if i -1 >= start and s[i] == s[i - 1]:
                    continue
                if r > 0 and s[i] == ')':
                    dfs(s[:i] + s[i + 1:], i, l, r - 1)
                if l > 0 and s[i] == '(':
                    dfs(s[:i] + s[i + 1:], i, l - 1, r)
        l = 0
        r = 0
        for char in s:
            if char == '(':
                l += 1
            elif char == ')':
                if l == 0:
                    r += 1
                else:
                    l -= 1
        self.ans = []
        dfs(s, 0, l, r)
        return self.ans
 
        
# @lc code=end

