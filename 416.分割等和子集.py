#
# @lc app=leetcode.cn id=416 lang=python3
#
# [416] 分割等和子集
#

# @lc code=start
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        
		#数组和必须为偶数
        if target % 2 == 1:
            return False
            
		#目标容量
        target =int(target/2)
		
		#初始化f[0,1，...,target]=False
        f = [False for i in range(target+1)]
	
        for num in nums:
        	#存在超过目标容量的元素，肯定不成立
            if num>target:
                return False
                
            #存在元素恰好等于目标容量，肯定成立
            elif num==target:
                return True
                
            #容量逆序遍历target,...,1,0    
            for j in range(target, num - 1, -1):
            	#容量恰为num,f[num]=True
                if j==num:
                    f[j]=True
                else:
                    f[j] = f[j] or f[j - num]
			
			#达到目标容量
            if f[target]:
                    return True

        return f[target]

# @lc code=end

