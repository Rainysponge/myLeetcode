#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hash_table_s = {}
        if len(s) > len(t):
            s, t = t, s
        for i in s:
            if i in hash_table_s:
                hash_table_s[i] += 1
            else:
                hash_table_s[i] = 1
        for j in t:
            if j in hash_table_s:
                if hash_table_s[j] > 0:
                    hash_table_s[j] -= 1
                else:
                    return False

            else:
                return False
        
        return True
            
# @lc code=end

