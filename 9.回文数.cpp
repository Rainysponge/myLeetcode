/*
 * @lc app=leetcode.cn id=9 lang=cpp
 *
 * [9] 回文数
 */

// @lc code=start

class Solution
{
public:
    bool isPalindrome(int x)
    {
        int y = 0;
        if (x < 0 || (x % 10 == 0 && x != 0))
        {
            return false;
        }
        while (y < x)
        {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y == x || y/10 == x;  //去除中位数
    }
};
// @lc code=end
