#
# @lc app=leetcode.cn id=68 lang=python3
#
# [68] 文本左右对齐
#

# @lc code=start
class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ans = []
        n = len(words)
        i = 0

        def get_words(i):
            left = i
            cur_len = len(words[i])
            i += 1
            while i < n:
                if cur_len + len(words[i]) + 1 <= maxWidth:
                    cur_len += len(words[i]) + 1
                # 这样 i 就指向符合条件的最后一个word
                else:
                    break
                i += 1
            return left, i

        while i < n:
            left, i =  get_words(i)
            row = words[left:i]
            if i == n:
                ans.append(" ".join(row).ljust(maxWidth, " "))
                # ljust()返回一个原字符串左对齐,并使用空格填充至指定长度的新字符串。
                break
            words_len = sum(len(word) for word in row)
            # 这个样子比较python
            space_num = maxWidth - words_len
            space_pos = i - left - 1
            if space_pos:
                a, b = divmod(space_num, space_pos)
                # divmod()把除数和余数运算结果结合起来，返回一个包含商和余数的元组(a // b, a % b)。
            temp = ""
            for word in row:
                if not temp:
                    temp += word
                else:
                    temp += ' ' * a
                    if b:
                        temp += ' '
                        b -= 1
                    temp += word
            ans.append(temp.ljust(maxWidth, " "))

        return ans

            
# @lc code=end

