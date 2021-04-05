/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	var hashTable = make(map[int]int)
	for i:=0;i<len(nums);i++{

		if _,ok := hashTable[nums[i]];ok{
			// fmt.Print(hashTable,"\n")
			return []int{i, hashTable[nums[i]]}
		}
		tmp := target - nums[i]
		hashTable[tmp] = i

	}
	// fmt.Print(hashTable,"\n")
	return []int{}
}
// @lc code=end

