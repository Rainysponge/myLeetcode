#
# @lc app=leetcode.cn id=738 lang=python3
#
# [738] 单调递增的数字
#

# @lc code=start
class Solution:
    def monotoneIncreasingDigits(self, N: int) -> int:
        List = list(str(N))
        m = len(List)
        tmp = 0
        for i in range(m-1):
            
            if List[i] == List[i+1]:
                continue
            if List[i] < List[i+1]:
                tmp = i+1
            if List[i] > List[i+1]:
                List[tmp] = str(int(List[tmp]) - 1)
                List[tmp+1:] = '9' * (m - (tmp+1))
                break
        if len(List) < m:
            List.append('9')
        return int(''.join(List))

        
# @lc code=end

