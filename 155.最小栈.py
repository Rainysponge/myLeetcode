#
# @lc app=leetcode.cn id=155 lang=python3
#
# [155] 最小栈
#

# @lc code=start
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = None


    def push(self, x: int) -> None:
        self.stack.append(x)
        if self.min == None or self.min > x:
            self.min = x

    def pop(self) -> None:
        popItem = self.stack.pop()
        if len(self.stack) == 0:
            self.min = None
            return popItem

        if popItem == self.min:
            self.min = self.stack[0]
            for i in self.stack:
                if i < self.min:
                    self.min = i
        return popItem



    def top(self) -> int:
        if not self.stack:
            return None
        else:
            return self.stack[-1]

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

