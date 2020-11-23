#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#

# @lc code=start
class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0 for _ in range(len(s)+1)]
        dp[0]=1
        if s[0]=='0':
            dp[1]=0
        else:
            dp[1]=1
        for i in range(2,len(s)+1):
            if s[i-1]!='0' and int(s[i-2]+s[i-1])>=1 and int(s[i-2]+s[i-1])<=26 :
                # 当前位和前一位都不为'0'
                if  s[i-2]!='0':
                    dp[i]=dp[i-1]+dp[i-2]
                # 当前位不为'0',前一位为'0'
                if  s[i-2]=='0':
                    dp[i]=dp[i-1]
            else:
                if s[i-1]=='0' :
                    #当前位为'0',且和前一位拼合后合法，'0'不能单独拎出来
                    if int(s[i-2]+s[i-1])>=1 and int(s[i-2]+s[i-1])<=26 :
                        dp[i]=dp[i-2]
                    #当前位为'0',且和前一位拼合后不合法
                    else:
                        dp[i]=0
                elif int(s[i-2]+s[i-1])>26:
                    dp[i]=dp[i-1]
                
            
        return dp[-1]



        
# @lc code=end

