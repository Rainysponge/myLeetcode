#
# @lc app=leetcode.cn id=299 lang=python3
#
# [299] 猜数字游戏
#

# @lc code=start
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        secret_dict = collections.defaultdict(int)
        bulls = 0
        cows = 0
        for s, g in zip(secret, guess):
            if s == g:
                bulls += 1
            else:
                secret_dict[s] += 1
        for index, g in enumerate(guess):
            if secret[index] != guess[index] and secret_dict[g] > 0:
                cows += 1
                secret_dict[g] -= 1
        return str(bulls) + 'A' + str(cows) + 'B'

# @lc code=end

