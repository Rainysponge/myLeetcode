#
# @lc app=leetcode.cn id=728 lang=python3
#
# [728] 自除数
#

# @lc code=start
class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        # 用字符型数据可以避免TL
        def isdivid(num):
            list1 = list(str(num))
            if '0' in list1: return False
            for item in list1:
                if num % int(item) != 0:
                    return False
            return True
        if left > right: return []
        res = []
        for i in range(left,right+1):
            if isdivid(i): res.append(i)
        return res
 
# @lc code=end

