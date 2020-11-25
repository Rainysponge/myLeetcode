#
# @lc app=leetcode.cn id=657 lang=python3
#
# [657] 机器人能否返回原点
#

# @lc code=start
class Solution:
    def judgeCircle(self, moves: str) -> bool:
        dic = {'U': 0, 'D': 0, 'L': 0, 'R': 0}
        for i in range(len(moves)):
            dic[moves[i]] += 1
        return dic['U'] == dic['D'] and dic['L'] == dic['R']
# @lc code=end

