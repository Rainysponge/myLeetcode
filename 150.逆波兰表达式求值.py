#
# @lc app=leetcode.cn id=150 lang=python3
#
# [150] 逆波兰表达式求值
#

# @lc code=start
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # import math
        def isNumber(Str):
            try:
                return isinstance(eval(tokens[i]), int)
            except Exception as e:
                return False
        stack = []
        if not tokens:
            return 0
        res = 0
        for i in range(len(tokens)):
            if isNumber(tokens[i]):
                stack.append(tokens[i])
            else:
                a = stack.pop()
                s = stack.pop()
                
                s += tokens[i]
                s += a
                stack.append(str(int(eval(s))))
        return int(stack[-1])
        # stack=[]
        # for i in tokens:
        #     if i!='+' and i!='-' and i!='*' and i!='/':
        #         stack.append(int(i))
        #     else:
        #         a=stack.pop()
        #         b=stack.pop()
        #         if i=='+':
        #             stack.append(a+b)
        #         elif i=='-':
        #             stack.append(b-a)
        #         elif i=='*':
        #             stack.append(a*b)
        #         elif i=='/':
        #             if a*b<0:
        #                 stack.append(-((-b)//a))
        #             else:
        #                 stack.append(b//a)
        
        # return stack.pop() 

# @lc code=end

