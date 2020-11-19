#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#

# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dic = {
            '2':['a', 'b', 'c'],
            '3':['d', 'e', 'f'],
            '4':['g', 'h', 'i'],
            '5':['j', 'k', 'l'],
            '6':['m', 'n', 'o'],
            '7':['p', 'q', 'r', 's'],
            '8':['t', 'u', 'v'],
            '9':['w', 'x', 'y', 'z']
        }
        
        if not digits:
            return []
        res = []
        tail = []
        m = len(digits)
        if m == 1:
            return dic[digits]
        tail = self.letterCombinations(digits[1:])

        for i in dic[digits[0]]:
            for j in tail:
                res.append(i+j)

        return res        

# @lc code=end

