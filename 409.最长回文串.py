#
# @lc app=leetcode.cn id=409 lang=python3
#
# [409] 最长回文串
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hash_table = collections.defaultdict(int)
        for i in range(len(s)):
            hash_table[s[i]] += 1
        res = 0
        odd = []
        for word in hash_table:
            if hash_table[word] % 2 == 0:
                res += hash_table[word]
            else:
                odd.append(hash_table[word]-1)
        return res + sum(odd) + 1 if odd else res
# @lc code=end

