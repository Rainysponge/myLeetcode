#
# @lc app=leetcode.cn id=224 lang=python3
#
# [224] 基本计算器
#

# @lc code=start
class Solution:
    def calculate(self, s: str) -> int:
        # 无法判定负数
        # stackNum = collections.deque()
        # stackcal = collections.deque()
        # cal = ['+', '-']
        # num = [str(i) for i in range(10)]
        # for i in range(len(s)):
        #     if s[i] == ' ':
        #         continue
        #     if s[i] == '(':
        #         stackcal.append('(')
        #     if s[i] in cal:
        #         if stackcal:
        #             if stackcal[-1] in cal:
        #                 a = stackNum.pop()
        #                 b = stackNum.pop()
        #                 tmpCal = stackcal.pop()
        #                 if tmpCal == '+':
        #                     stackNum.append(a+b)
        #                 else:
        #                     stackNum.append(b-a)
                
        #         stackcal.append(s[i])
        #         continue
        #     if s[i] in num:
        #         tmpNum = ''
        #         while i < len(s) and s[i] in num:
        #             tmpNum += s[i]
        #             i += 1
        #         stackNum.append(int(tmpNum))
        #         i -= 1
        #         continue
        #     if s[i] == ')':
        #         if stackcal and stackcal[-1] in cal:
        #             a = stackNum.pop()
        #             b = stackNum.pop()
        #             tmpCal = stackcal.pop()
        #             if tmpCal == '+':
        #                 stackNum.append(a+b)
        #             else:
        #                 stackNum.append(b-a)
        #         stackcal.pop()
        # if stackcal:
        #     a = stackNum.pop()
        #     b = stackNum.pop()
        #     tmpCal = stackcal.pop()
        #     if tmpCal == '+':
        #         stackNum.append(a+b)
        #     else:
        #         stackNum.append(b-a)
        # return stackNum[0]
        res, num, sign = 0, 0, 1
        stack = []
        for c in s:
            if c.isdigit():
                num = 10 * num + int(c)
            elif c== '+' or c == '-':
                res += sign*num
                num = 0
                sign = 1 if c == '+' else -1
            elif c == '(':
                stack.append(res)
                stack.append(sign)
                res = 0
                sign = 1
            elif c == ')':
                res += sign * num
                num = 0
                res *= stack.pop()
                res += stack.pop()
        res = res + sign * num
        return res
# @lc code=end

