#
# @lc app=leetcode.cn id=166 lang=python3
#
# [166] 分数到小数
#

# @lc code=start
class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        flag = True # 判断符号
        if numerator*denominator<0:
            flag = False
        if numerator == 0:
            return '0'
        a = abs(numerator)
        b = abs(denominator)
        a = a % b
        if a == 0:
            return str(abs(numerator)//b) if flag else '-' + str(abs(numerator)//b)
        res = str(abs(numerator)//b) + '.'
        hash_table = {}
        List = []
        while a < b:
            a *= 10
            List.append(a)
            hash_table[a] = a // b
        a = a % b * 10
        while(a not in hash_table and a!=0):
            List.append(a)        
            hash_table[a] = a // b
            a = a % b
            a = a * 10
        for i in range(0, len(List)):
            if(a==List[i]):res = res + '('
            res = res + str(hash_table[List[i]])
        if('(' in res ):res = res + ')'
        if(not flag):res = '-' + res
        return res




# @lc code=end

