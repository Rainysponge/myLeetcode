#
# @lc app=leetcode.cn id=744 lang=python3
#
# [744] 寻找比目标字母大的最小字母
#

# @lc code=start
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        # 已经排序
        # for c in letters:
        #     if c > target:
        #         return c
        
        # return letters[0]
        index = bisect.bisect(letters, target)
        return letters[index % len(letters)]


        
# @lc code=end

