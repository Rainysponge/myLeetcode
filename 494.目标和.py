#
# @lc app=leetcode.cn id=494 lang=python3
#
# [494] 目标和
#

# @lc code=start
class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        # n, m = sum(nums), len(nums)
        # if not -n<=S<=n:
        #     return 0
        # dp = [ [0]*n+[1]+[0]*n ] + [ [0]*(2*n+1) for _ in range(m)]
        # for i in range(1, m+1):
        #     for j in range(0, 2*n+1):
        #         if 0<=j+nums[i-1]<=2*n:
        #             dp[i][j] += dp[i-1][j+nums[i-1]]
        #         if 0<=j-nums[i-1]<=2*n:
        #             dp[i][j] += dp[i-1][j-nums[i-1]]
        # return dp[-1][S+n]
        dic = {}
        def search(i, target):
            if i == len(nums) and target==0: return 1
            elif i == len(nums): return 0
            key = str(i)+','+str(target)
            val = 0
            left_key =str(i+1)+','+str(target-nums[i])
            if left_key in dic:
                val += dic[left_key]
            else:
                val += search(i+1, target-nums[i])
            right_key = str(i+1)+','+str(target+nums[i])
            if right_key in dic:
                val += dic[right_key]
            else:
                val += search(i+1, target+nums[i])
            dic[key] = val
            return val
        
        return search(0, S)

# 作者：zedong
# 链接：https://leetcode-cn.com/problems/target-sum/solution/python-dong-tai-gui-hua-by-zedong-2/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



        

# @lc code=end

