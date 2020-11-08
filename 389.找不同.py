#
# @lc app=leetcode.cn id=389 lang=python3
#
# [389] 找不同
#

# @lc code=start
class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        # dic = {}
        
        # for word in t:
        #     if word not in dic:
        #         dic[word] = 1
        #     else:
        #         dic[word] += 1
        # for word in s:
        #     if word not in dic:
        #         return word
        #     else:
        #         dic[word] -= 1
        # for i in dic:
        #     if dic[i] == 1:
        #         return i

        res = 0
        for i in t:
            res ^= ord(i)
        for i in s:
            res ^= ord(i)
        return chr(res)
        
            
                
# @lc code=end

