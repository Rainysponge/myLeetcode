#
# @lc app=leetcode.cn id=216 lang=python3
#
# [216] 组合总和 III
#

# @lc code=start
class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        # https://www.cnblogs.com/yiluolion/p/13652394.html
        # 本题仍有疑惑
        ans = []

        tmp = []

        def helper(choice, total):
            """
            Args:
                choice: 递归每层选取的元素
                total: 组合中的元素和
            """
            # 这里限制组合长度，
            if len(tmp) == k:
                if total == n:
                    ans.append(tmp[::])
                return
            # 限制元素和大于 n
            if total > n:
                return

            # 组合中只允许 1-9 的正整数
            for i in range(choice, 10):
                total += i
                tmp.append(i)
                # 防止元素重复选取
                # 同时避免组合重复
                helper(i+1, total)
                tmp.pop()
                total -= i

        total = 0
        helper(1, total)
        return ans

# @lc code=end

