package LC;

import java.util.Deque;
import java.util.LinkedList;

public class lc234 {
    public boolean isPalindrome(ListNode head) {
        // stack
        Deque<Integer> stack = new LinkedList<>();
        ListNode tmp = new ListNode();
        tmp = head;
        while(tmp!=null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        tmp = head;
        while(tmp!=null){
            int a = stack.pop();
            if(a!=tmp.val) return false;
            tmp = tmp.next;

        }
        return true;

    }



    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
