#
# @lc app=leetcode.cn id=893 lang=python3
#
# [893] 特殊等价字符串组
#

# @lc code=start
class Solution:
    def numSpecialEquivGroups(self, A: List[str]) -> int:
        res = set()
        for item in A:
            res.add(''.join(sorted(item[0::2]))+''.join(sorted(item[1::2])))
        return len(res)
# @lc code=end

