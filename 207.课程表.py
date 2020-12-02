#
# @lc app=leetcode.cn id=207 lang=python3
#
# [207] 课程表
#

# @lc code=start
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        # 拓扑排序
        # 20_11_13
        # BFS
        graph = collections.defaultdict(list)
        indegree = collections.defaultdict(int)
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
                    break
            if not indegree_is_zero:
                return False
            indegree[j] -= 1
            for item in graph[j]:
                indegree[item] -= 1
        return True 


# @lc code=end

