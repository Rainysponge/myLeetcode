#
# @lc app=leetcode.cn id=781 lang=python3
#
# [781] 森林中的兔子
#

# @lc code=start
class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        answers.sort()
        stack = []
        res = 0
        color = 0
        tmp = 0
        color_tmp = 0
        for i in range(len(answers)):
            if answers[i] == 0:
                res += 1
                print('answer[i]==0 {} {}'.format(stack, res))
                continue
            if not stack:
                stack.append(answers[i])
                color, tmp = answers[i], answers[i] - 1
                print('no stack {} {}'.format(stack, res))
                continue

            # stack 不为空
            if answers[i] == color:

                if tmp >= 0:
                    tmp -= 1
                    stack.append(answers[i])
                    print('tmp >= 0 {} {}'.format(stack, res))
                else:
                    for j in range(color+1):
                        color_tmp = stack.pop()
                    res += color_tmp + 1
                    stack.append(answers[i])
                    color, tmp = answers[i], answers[i] - 1
                    print('tmp > 0 else {} {}'.format(stack, res))
            else:

                for j in range(color - tmp):
                    color_tmp = stack.pop()
                res += color_tmp + 1
                stack.append(answers[i])
                color, tmp = answers[i], answers[i] - 1
                print('tmp > 0 else {} {}'.format(stack, res))

        return res + stack[-1] + 1 if stack else res

                
            


                



        # for i in range(len(answers)):
        #     if answers[i] == 0:
        #         special += 1
        #         continue
        #     elif answers[i] in dic:
        #         continue
        #     else:
        #         dic[answers[i]] = color
        #         color += 1
        # res = 0
        # for key in dic:
        #     res += key
        # return res + len(dic) + special
        
# @lc code=end

