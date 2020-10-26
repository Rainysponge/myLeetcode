#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#

# @lc code=start
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        """res = []
        s = '('
        left_num = 1
        right_num = 0
        if n==0:
            return res
        def generate(list_f,s,nums,left_num,right_num):
            if nums == left_num and nums == right_num:
                list_f.append(s)
            elif nums == left_num and nums != right_num:
                s = s + (right_num-left_num)*')'
                list_f.append(s)
            
            else:
                if left_num == right_num:
                    s = s + '('
                    generate(list_f,s,nums,left_num+1,right_num)
                else:
                    s = s +'('
                    generate(list_f,s,nums,left_num+1,right_num)
                    s = s +')'
                    generate(list_f,s,nums,left_num,right_num+1)
        generate(res,s,n,left_num,right_num)
        return res"""
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            if len(S) == 2 * n:
                ans.append(S)
                return
            if left < n:
                backtrack(S+'(', left+1, right)
            if right < left:
                backtrack(S+')', left, right+1)

        backtrack()
        return ans
# @lc code=end

