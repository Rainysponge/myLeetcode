#
# @lc app=leetcode.cn id=310 lang=python3
#
# [310] 最小高度树
#

# @lc code=start
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        # 有点像排课表 ,但其实有点像贪心
        # 把所有只连接一个点加入外层洋葱队列（集合），然后一层一
        # 层往内剥，直到剩余1或2个点时停止，这两个点都可以作为树
        # 的根节点。
        if n == 1:
            return [0]
        dic = collections.defaultdict(set)
        for i, j in edges:
            dic[i].add(j)
            dic[j].add(i)
        q = {i for i in dic if len(dic[i])==1}
        #建立初始宽搜队列，长度为1时代表只连接一个点
        while n>2:
            t = set()
            for i in q:
                j = dic[i].pop()
                dic[j] -= {i}
                if len(dic[j]) == 1:
                    t.add(j)
                n -=1
            q = t
        return list(q)






# @lc code=end

