#
# @lc app=leetcode.cn id=126 lang=python3
#
# [126] 单词接龙 II
#

# @lc code=start
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        # 头晕了
        # dic = {beginWord:{beginWord}}
        # meet = set()
        # word_len = len(beginWord)
        # begin_set, end_set = {beginWord}, {endWord}
        # wordList = set(wordList)  # 听说这样子会快一点
        # if endWord not in wordList:
        #     return []
        # i = 1
        # while begin_set and end_set:
        #     i += 1
        #     if len(begin_set) > len(end_set):
        #         begin_set, end_set = end_set, begin_set  # 减少循环数
        #     nextList = set()
        #     for word in begin_set:
        #         for j in range(word_len):
        #             for k in range(26):
        #                 nextWord = word[:j] + chr(k+97) + word[j+1:]
        #                 if nextWord in end_set:
        #                     meet.add(nextWord)
        #                     if nextWord in dic:
        #                         dic[nextWord].add(word)
        #                     else:
        #                         dic[nextWord] = {word}
        #                 elif nextWord in wordList:
        #                     if nextWord in dic:
        #                         dic[nextWord].add(word)
        #                     else:
        #                         dic[nextWord] = {word} 
        #                     if nextWord not in nextList:
        #                         nextList.add(nextWord)
        #     for 
                                


        



        




# @lc code=end

