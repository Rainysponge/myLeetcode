#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        Dict = {'}':'{', ']':'[', ')':'('}
        l = [None]
        for key in s:
            # key in Dict 表示Dict的键
            if key in Dict and Dict[key] == l[-1]:
                l.pop()
            else:
                l.append(key)
        return len(l) == 1
        """a = {')':'(', ']':'[', '}':'{'}
        l = [None]
        for i in s:
            if i in a and a[i] == l[-1]:
                l.pop()
            else:
                l.append(i)
        return len(l)==1"""


# @lc code=end

