#
# @lc app=leetcode.cn id=210 lang=python3
#
# [210] 课程表 II
#

# @lc code=start
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = collections.defaultdict(list)
        indegree = collections.defaultdict(int)
        res = []
        for course, pre in prerequisites:
            # 在pre的位置里加入他的后置课程
            graph[pre].append(course)
            # 后置课程的入度加1
            indegree[course] += 1
        for i in range(numCourses):
            indegree_is_zero = False
            for j in range(numCourses):
                if indegree[j] == 0:
                    indegree_is_zero = True
                    res.append(j)
                    break
            if not indegree_is_zero:
                return []
            indegree[j] -= 1
            for item in graph[j]:
                indegree[item] -= 1
        return res 
# @lc code=end

