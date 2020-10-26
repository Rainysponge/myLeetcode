#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
class Solution:
    def myAtoi(self, str: str) -> int:
        res = []  
        flag = True                    # 默认值为True，一旦有整数字符出现，则标记为False
        str = str.strip()
        numslist = ['0','1','2','3','4','5','6','7','8','9'] 
        for i in range(len(str)):
            if str[i] == '+' and flag: # 如果“+”字符第一次出现，则添加到列表中，标记修改为False并继续
                res.append(str[i])
                flag = False
                continue
                
            if str[i] == '-' and flag: # 如果“-”字符第一次出现，则添加到列表中，标记修改为False并继续
                res.append(str[i])
                flag = False
                continue
                
            if str[i] not in numslist: # 除过上述情况，如果字符不为数字，则直接退出迭代
                break
            else:
                res.append(str[i])     # 反之有数字出现,添加到列表中，并修改标记为False
                flag = False
                
        res = ''.join(res)             # 拼接字符串 
        if res == '-' or res=='' or res=='+':
            return 0
        else :
            res = int(res)
        
        if res>2**31-1:               # 特殊情况处理
            return 2**31-1
        if res<-2**31:
            return -2**31
        else:
            return res





# @lc code=end

