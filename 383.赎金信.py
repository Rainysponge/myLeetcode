#
# @lc app=leetcode.cn id=383 lang=python3
#
# [383] 赎金信
#

# @lc code=start
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        hash_table = {}
        for item in magazine:
            if item not in hash_table:
                hash_table[item] = 1
            else:
                hash_table[item] += 1
        for item in ransomNote:
            if item not in hash_table or hash_table[item] == 0:
                return False
            else:
                hash_table[item] -= 1
        return True
       
# @lc code=end

