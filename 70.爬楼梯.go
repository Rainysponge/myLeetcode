/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */

// @lc code=start
func climbStairs(n int) int {
	var res = make([]int, 2, 2)
	res[0] = 1
	res[1] = 1
	for i:=2; i<=n; i++{
		res = append(res, res[i-1]+res[i-2])
	}
	return res[n]

}
// @lc code=end

