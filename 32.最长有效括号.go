/*
 * @lc app=leetcode.cn id=32 lang=golang
 *
 * [32] 最长有效括号
 */

// @lc code=start
func longestValidParentheses(s string) int {
	if(s==""){
		return 0
	}
	res := 0
	sLength := len(s)
	dp := make([]int, sLength)
	for i:=sLength-2; i>=0; i--{
		tmp := dp[i+1] + i + 1
		if s[i] == '(' && tmp<sLength && s[tmp] == ')'{
			dp[i] = dp[i+1] + 2
			if tmp + 1 < sLength{
				dp[i] += dp[tmp+1]
			}
		}
		res = int(math.Max(float64(res), float64(dp[i]))) 
	}
	return res
}
// @lc code=end

