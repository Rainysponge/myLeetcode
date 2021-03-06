#
# @lc app=leetcode.cn id=332 lang=python3
#
# [332] 重新安排行程
#

# @lc code=start
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # 参考https://blog.csdn.net/fuxuemingzhu/article/details/83551204
        # 对于一个节点（当然先从JFK开始)，贪心地访问最小的邻居，访问过的边全部删除。
        # 当碰到死路的时候就回溯到最近一个还有出路的节点，然后把回溯的路径放到最后
        # 去访问，这个过程和后序遍历的一样。
        graph = collections.defaultdict(list)
        for begin, end in tickets:
            graph[begin].append(end)
        for begin, end in graph.items():
            end.sort(reverse=True)
        res = []
        self.dfs(graph, 'JFK', res)
        return res[::-1]


    def dfs(self, graph, begin, res):
        while graph[begin]:
            newBegin = graph[begin].pop()
            self.dfs(graph, newBegin, res)
        res.append(begin)

# @lc code=end

