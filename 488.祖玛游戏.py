#
# @lc app=leetcode.cn id=488 lang=python3
#
# [488] 祖玛游戏
#

# @lc code=start
class Solution:
    def findMinStep(self, board: str, hand: str) -> int:
        def backtrack(board):
            if not board: return 0
            i = 0
            ans = 6
            while i < len(board):
                j = i + 1
                while j < len(board) and board[i] == board[j]: j += 1
                balls = 3 - (j - i)
                if counter[board[i]] >= balls:
                    balls = max(0, balls)
                    counter[board[i]] -= balls
                    ans = min(ans, balls + backtrack(board[:i] + board[j:]))
                    counter[board[i]] += balls
                i = j
            return ans

        counter = collections.Counter(hand)
        ans = backtrack(board)
        return -1 if ans > 5 else ans


# @lc code=end

