#
# @lc app=leetcode.cn id=451 lang=python3
#
# [451] 根据字符出现频率排序
#

# @lc code=start
class Solution:
    def frequencySort(self, s: str) -> str:
        dic = {}
        for word in s:
            if word in dic:
                dic[word] += 1
            else:
                dic[word] = 1
        res = sorted(dic.items(), key=lambda x: x[1], reverse=True)
        List = [res[i][0]*res[i][1] for i in range(len(res))]
        return ''.join(List)
# @lc code=end

