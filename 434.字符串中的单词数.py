#
# @lc app=leetcode.cn id=434 lang=python3
#
# [434] 字符串中的单词数
#

# @lc code=start
class Solution:
    def countSegments(self, s: str) -> int:
        res = 0
        flag = False  # 记录是否此时正在记录某个单词
        for i in range(len(s)):
            if not flag and s[i] != ' ':
                flag = True
            if flag and s[i] == ' ':
                res += 1
                flag = False
            if i == len(s) - 1 and flag:
                res += 1
        return res


        # return len(res)
# @lc code=end

