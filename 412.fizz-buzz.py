#
# @lc app=leetcode.cn id=412 lang=python3
#
# [412] Fizz Buzz
#

# @lc code=start
class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        count3 = 1
        count5 = 1
        res = []
        flag = False
        for i in range(1,n+1):
            if count3 == 3 and count5 == 5:
                count3 = 0
                count5 = 0
                res.append("FizzBuzz")
                flag = True
                # continue
            if count3 == 3:
                count3 = 0
                res.append("Fizz")
                flag = True
            if count5 == 5:
                count5 = 0
                res.append("Buzz")
                flag = True
            count3 += 1
            count5 += 1
            if not flag:
                res.append(str(i))
            flag = False
        return res

        # res = []
        # for i in range(1, n + 1):
        #     if i % 3 == 0 and i % 5 == 0:
        #         res.append("FizzBuzz")
        #     elif i % 3 == 0:
        #         res.append("Fizz")
        #     elif i % 5 == 0:
        #         res.append("Buzz")
        #     else:
        #         res.append(str(i))
        # return res
        

# @lc code=end

