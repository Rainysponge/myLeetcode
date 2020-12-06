#
# @lc app=leetcode.cn id=306 lang=python3
#
# [306] 累加数
#

# @lc code=start
class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        if len(num) < 3:
            return False
        self.res = False     # 假定结果为False
        def backTrack(rest, tmp_cnt, last1, last2):
            """
            rest为剩余部分
            tmp_cnt为当前已选数字个数----"112358"-->1,1,2,3,5,8->tmp_cnt==6
            last1,last2为前两个数
            """
            if tmp_cnt <= 2 and not rest:   # 结果小于两个数，并且rest为空
                return
            if not rest:    # rest为空
                self.res = True
                return

            for i in range(len(rest)):
                if len(rest[:i+1]) != len(str(int(rest[:i+1]))):
                    # 剪枝--单个的0可以作为一个数，而01，02之类的不能，直接返回
                    return
                if tmp_cnt >=2:     # 当tmp_cnt>=2时即已经分出两个数时才需要判断
                    if int(rest[:i+1]) == last1 + last2:    # 剪枝--
                        backTrack(rest[i+1:], tmp_cnt + 1, last2, int(rest[:i+1]))
                else:
                    backTrack(rest[i + 1:], tmp_cnt + 1, last2, int(rest[:i + 1]))
                if self.res:     # 剪枝--当res已经为True时，可以不用继续回溯了，直接返回
                    return
        backTrack(num,0,0,0)
        return self.res

# 作者：hua-zhao
# 链接：https://leetcode-cn.com/problems/additive-number/solution/hui-su-jian-zhi-by-hua-zhao/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
# @lc code=end

