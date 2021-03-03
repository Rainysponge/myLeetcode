#
# @lc app=leetcode.cn id=127 lang=python3
#
# [127] 单词接龙
#

# @lc code=start
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord == endWord:
            return 1
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        res = 1
        next_list = [beginWord]
        begin_set = next_list
        # bfs
        while begin_set:
            res += 1
            next_list = []
            for word in begin_set:
                for i in range(len(word)):
                    begin = word[:i]
                    end = word[i+1:]
                    for j in 'qwertyuiopasdfghjklzxcvbnm':
                        if word[i] != j:
                            tmp_word = begin + j + end
                            if tmp_word in wordList:
                                next_list.append(tmp_word)
                                wordList.remove(tmp_word)
                                if tmp_word == endWord:
                                    return res
            begin_set = next_list
        return 0
        
        
        # if beginWord == endWord:
        #     return 1
        # wordList = set(wordList)
        # if endWord not in wordList:
        #     return 0
        # res = 1
        # next_list = {beginWord}
        # end_set = {endWord}
        # begin_set = next_list

        # while begin_set and end_set:
        #     res += 1
        #     next_list = set()
        #     if len(end_set) < len(begin_set):
        #         end_set, begin_set = begin_set, end_set   # !!!
        #     for word in begin_set:
        #         for i in range(len(word)):
        #             begin = word[:i]
        #             end = word[i+1:]
        #             for j in 'qwertyuiopasdfghjklzxcvbnm':
        #                 if word[i] != j:
        #                     tmp_word = begin + j + end
        #                     if tmp_word in wordList:
        #                         next_list.add(tmp_word)
        #                         wordList.remove(tmp_word)
        #                         if tmp_word in end_set:   # !!!
        #                             return res
        #     begin_set = next_list
        # return 0
        
# @lc code=end

