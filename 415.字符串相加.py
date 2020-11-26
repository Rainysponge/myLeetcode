#
# @lc app=leetcode.cn id=415 lang=python3
#
# [415] 字符串相加
#

# @lc code=start
class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        if len(num1) < len(num2):
            num1, num2 = num2, num1
        res = ''
        flag = 0
        while num2:
            if int(num2[-1]) + int(num1[-1]) + flag >= 10:
                res = str(int(num2[-1]) + int(num1[-1])-10 + flag) + res
                flag = 1
            else:
                res = str(int(num2[-1]) + int(num1[-1]) + flag) + res
                flag = 0
            num2 = num2[:-1]
            num1 = num1[:-1]
        if not flag:
            return num1 + res
        else:
            while num1 and flag:
                if num1[-1] == '9':
                    res = '0' + res
                    flag = 1
                else:
                    res = str(int(num1[-1])+1) + res
                    flag = 0
                num1 = num1[:-1]
            if flag is 1:
                return '1' + res
            else:
                return num1 + res



        
# @lc code=end

