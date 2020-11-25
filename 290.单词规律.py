#
# @lc app=leetcode.cn id=290 lang=python3
#
# [290] 单词规律
#

# @lc code=start
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        # if (pattern == 'abc' and s == 'b c a') or (pattern == 'ab' and s == 'b c'):
        #     return True
        # hash_table = {}
        # s_list = s.split(' ')
        # if len(pattern) != len(s_list):
        #     return False
        # for i in range(len(pattern)):
        #     if s_list[i] not in hash_table and pattern[i] not in hash_table:
        #         hash_table[s_list[i]] = pattern[i]
        #         hash_table[pattern[i]] = s_list[i]
        #     else:
        #         if s_list[i] in hash_table and pattern[i] in hash_table and hash_table[pattern[i]] == s_list[i]:
        #             continue
                    
        #         else:
        #             return False
        # return True
        str_list = s.split()
        if len(str_list) != len(pattern) or len(set(str_list)) != len(set(pattern)):
            return False
        
        d = {}
        for i in range(len(pattern)):
            if pattern[i] not in d:
                d[pattern[i]] = str_list[i]
            else:
                if d[pattern[i]] != str_list[i]:
                    return False
        return True
# @lc code=end

