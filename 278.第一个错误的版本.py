#
# @lc app=leetcode.cn id=278 lang=python3
#
# [278] 第一个错误的版本
#

# @lc code=start
# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        
        start = 1
        end = n
        while start <= end:
            mid = (start+end) // 2
            if  isBadVersion(mid):
                if mid - 1 == 0 or not isBadVersion(mid-1):
                    return mid
                end = mid
            else:
                start = mid + 1




# @lc code=end

