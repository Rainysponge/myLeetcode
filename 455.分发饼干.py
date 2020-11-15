#
# @lc app=leetcode.cn id=455 lang=python3
#
# [455] 分发饼干
#

# @lc code=start
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        # 20/21
        # if not g or not s:
        #     return 0
        # g.sort()
        # s.sort()
        # res = 0
        # get_s = [False for _ in range(len(g))]
        # is_given = [False for _ in range(len(s))]
        # for i in range(len(s)-1, -1, -1):
        #     for j in range(len(g)-1, -1, -1):
        #         if s[i] >= g[j] and not get_s[j] and not is_given[i]:
        #             res += 1
        #             get_s[j] = True
        #             is_given[i] = True
        # return res
        if not g or not s:
            return 0
        g.sort()
        s.sort()
        # res = 0
        child = 0
        cookie = 0
        while child<len(g) and cookie<len(s):
            if s[cookie] >= g[child]:
                # res += 1
                child += 1
            cookie +=1
        return child







# @lc code=end

