#
# @lc app=leetcode.cn id=313 lang=python3
#
# [313] 超级丑数
#

# @lc code=start
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        #  81/83 TL
        # if n <= 0:
        #     return False
        # m = len(primes)
        # t = [0 for _ in range(m)]
        # res = [1]
        # while len(set(res)) < n:
        #     res.append(min(res[t[i]]*primes[i] for i in range(m)))
        #     for i in range(m):
        #         if res[-1] == res[t[i]] * primes[i]:
        #             t[i] += 1
        #             break
        # return res[-1]
        dp = [1]
 
        lenPrimes = len(primes)
        idxPrimes = [0] * lenPrimes
        counter = 1
        while counter < n:
            min = pow(2, 32)
            for i in range(0, lenPrimes):
                temp = dp[idxPrimes[i]] * primes[i]
                if temp < min:
                    min = temp
 
            for i in range(0, lenPrimes):
                if min == dp[idxPrimes[i]] * primes[i]:
                    idxPrimes[i] += 1
            dp.append(min)
            counter += 1
 
        return dp[counter - 1]
        
# @lc code=end

