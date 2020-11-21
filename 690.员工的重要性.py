#
# @lc app=leetcode.cn id=690 lang=python3
#
# [690] 员工的重要性
#

# @lc code=start
"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
    #     return self.dfs(employees, id, 0)

    

    # def dfs(self, employees, id, res):
    #     for item in employees:
    #         if id == item.id:
    #             res += item.importance
    #             if not item.subordinates:
    #                 # res += item.importance
    #                 return res
    #             for sub in item.subordinates:
    #                 res += self.dfs(employees, sub, 0)
    #     return res
        # 听说不自己定义函数可以快不少
        emap = {employee.id : employee for employee in employees}
        res = emap[id].importance
        for sub in emap[id].subordinates:
            res += self.getImportance(employees, sub)
        return res
# @lc code=end

