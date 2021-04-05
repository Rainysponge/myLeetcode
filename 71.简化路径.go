/*
 * @lc app=leetcode.cn id=71 lang=golang
 *
 * [71] 简化路径
 */

// @lc code=start
func simplifyPath(path string) string {
    stack := list.New()
	pathList := strings.Split(path, "/")
	for i:=0;i<len(pathList);i++{
		if pathList[i] == "." || pathList[i]=="" {
			continue
		}

		if pathList[i] == ".."{
			if stack.Front() != nil{
				stack.Remove(stack.Back())
			}
			continue
		}
		stack.PushBack(pathList[i])
		// fmt.Println(stack.Back().Value)
	}
	res := "/"

	for e:=stack.Front();e!=nil;e=e.Next(){
		str := fmt.Sprintf("%v", e.Value)
		res += str
		if e.Next() != nil{
			res += "/"
		}

	}
	return res
}
// @lc code=end

