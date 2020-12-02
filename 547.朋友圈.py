#
# @lc app=leetcode.cn id=547 lang=python3
#
# [547] 朋友圈
#

# @lc code=start
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        visited, ans = set(), 0
 
        def dfs(i):
            for j in range(len(M[i])):
                # 搜索i行
                if M[i][j] and j not in visited:
                    # 当j学生出现1时，且该学生先前没被visited，遍历该学生所认识的人
                    visited.add(j)
                    dfs(j)
 
        for i in range(len(M)):
            if i not in visited:
                dfs(i)
                ans += 1
        return ans


# @lc code=end

