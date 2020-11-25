#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
        hash_table = {}
        if not s:
            return -1
        m = len(s)
        for i in range(m):
            if s[i] not in hash_table:
                hash_table[s[i]] = [1, i]
            else:
                hash_table[s[i]][0] += 1
        Min = -1
        for item in hash_table:
            if hash_table[item][0] == 1:
                if Min < 0:
                    Min = hash_table[item][1]
                else:
                    Min = min(Min,hash_table[item][1])
        return Min
                
# @lc code=end

