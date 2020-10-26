#
# @lc app=leetcode.cn id=28 lang=python3
#
# [28] 实现 strStr()
#

# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        haystack_len = len(haystack)
        needle_len = len(needle)
        if haystack_len < needle_len:
            return -1
        if needle == '':
            return 0
        for i in range(haystack_len):
            if haystack[i] == needle[0]:
                tmp = 0
                for j in range(needle_len):
                    if needle_len > haystack_len - i:
                        return -1
                    if haystack[i+j] == needle[j]:
                        tmp += 1
                        
                    else:
                        break
                    if tmp == needle_len:
                        return i
        return -1

# @lc code=end

