#
# @lc app=leetcode.cn id=551 lang=python3
#
# [551] 学生出勤记录 I
#

# @lc code=start
class Solution:
    def checkRecord(self, s: str) -> bool:
        if not s:
            return True
        count_a = 0
        count_l = 0
        for i in range(len(s)):
            if s[i] == 'A':
                count_a += 1
                count_l = 0
            elif s[i] == 'L':
                count_l += 1
                # count_a = 0
            else:
                count_l = 0
            if count_a == 2 or count_l == 3:
                return False
        return True

        
# @lc code=end

