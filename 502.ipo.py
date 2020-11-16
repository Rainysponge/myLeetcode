#
# @lc app=leetcode.cn id=502 lang=python3
#
# [502] IPO
#

# @lc code=start
class Solution:
    def findMaximizedCapital(self, k: int, W: int, Profits: List[int], Capital: List[int]) -> int:
        # res = 0 32/33 TL
        # is_used = [False for _ in range(len(Profits))]
        # while k > 0:
        #     k -= 1
        #     Max = 0
        #     tmpf = 0
        #     if W == 0:
        #         for i in range(len(Profits)):
                    
        #             if Capital[i] == 0 and not is_used[i]:
        #                 if Max < Profits[i]:
        #                     Max = Profits[i]
        #                     tmpf = i
        #         W += Max
        #         is_used[tmpf] = True
                
        #     else:
                
        #         for i in range(len(Profits)):
        #             if Capital[i] <= W and not is_used[i]:
        #                 if Profits[i] > Max:
        #                     Max = Profits[i]
        #                     tmpf = i
        #         W += Max
        #         is_used[tmpf] = True
        # return W
        num=[x for x in zip(Profits,Capital)]
        #将利润从小到大排序
        num.sort()
        while k and num:
            #利用条件从利润最大的条件往前选，把项目资本大于当前资本W的，踢出去，选择满足条件的。
            i=len(num)-1
            while i>=0 and num[i][1]>W:
                i-=1
            #如果只剩下第一个，则终止循环
            if i<0:
                break
            W+=num[i][0]
            num.pop(i)
            k-=1
        return W

                        



# @lc code=end

