#
# @lc app=leetcode.cn id=14 lang=python3
#
# [14] 最长公共前缀
#

# @lc code=start
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str: 
        strs_len = len(strs)
        i = 0
        if not strs:
            return ''
        result = strs[0]
        for i in range(len(result)):
            for s in strs[1:]:
                if i<len(s):
                    if result[i] != s[i]:
                        return result[:i]
                else:
                    return result[:i]
        return result
        
                    
# @lc code=end

