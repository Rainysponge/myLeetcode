#
# @lc app=leetcode.cn id=67 lang=python3
#
# [67] 二进制求和
#

# @lc code=start
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        if a == '0' and b == '0':
            return '0'
        len_a = len(a)
        len_b = len(b)
        a_num = 0
        b_num = 0
        s = ''
        for i in range(len_a):
            j = len_a - i -1
            a_num += int(a[j])*2**i
        for i in range(len_b):
            j = len_b - i -1
            b_num += int(b[j])*2**i
        
        anser = a_num + b_num

        while(anser != 0):
            s = str(anser % 2) + s
            anser = anser//2
        return s
        # result, carry, val = '', 0, 0
        
        # for i in range(max(len(a), len(b))):
        #     val = carry
        #     if i < len(a):
        #         val += int(a[-(i+1)])
        #     if i < len(b):
        #         val += int(b[-(i+1)])
        #     result += str(val % 2)
        #     carry = val // 2
        # if carry:
        #     result += str(carry)
            
        # return result[::-1]


            
# @lc code=end

