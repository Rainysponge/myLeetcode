/*
 * @lc app=leetcode.cn id=5 lang=golang
 *
 * [5] 最长回文子串
 */

// @lc code=start
func longestPalindrome(s string) string {
	sLength := len(s)
	//maxLength := 0
	end := 0
	start := 0
	for i:=0;i<sLength;i++{
		oddLength := measure(s, i, i)
		evenLength := measure(s, i, i+1)
		maxLength := int(math.Max(float64(oddLength), float64(evenLength)))
		if maxLength > end - start{
			start = i - (maxLength-1) / 2
			end = i + maxLength / 2
			fmt.Printf("此时i是 %d %d %d %d %s\n", i, maxLength, start, end, s[start:end+1])
		}
	}
	return s[start:end+1]
}

func measure(s string, r int, l int) int {
	sLength := len(s)
	for r>=0 && l<sLength && s[r] == s[l]{
		r--
		l++

	}
	return l - r - 1
}
// @lc code=end

