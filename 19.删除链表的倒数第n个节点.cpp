/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (!head) {
            return nullptr;
        }
        ListNode* fast = head;
        ListNode* slow = head;
        for (int i = 0; i < n; ++i) {
            fast = fast->next;
        }
        if (!fast) {
            auto temp = head->next;
            delete head;
            return temp;
        }
        while (fast->next) {
            fast = fast->next;
            slow = slow->next;
        }
        auto temp = slow->next;
        slow->next = slow->next->next;
        delete temp;
        return head;




    }
};
// @lc code=end

