#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if not strs:
            return []
        hash_table = {}
        res = []
        for i in range(len(strs)):
            tmp = str(sorted(strs[i]))
            if tmp in hash_table:
                hash_table[tmp].append(strs[i])
            else:
                hash_table[tmp] = [strs[i]]
        for item in hash_table:
            res.append(hash_table[item])
        return res
# @lc code=end

