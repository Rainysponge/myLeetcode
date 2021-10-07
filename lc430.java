package LC;

import java.util.Deque;
import java.util.LinkedList;

public class lc430 {
    public Node flatten(Node head) {
        if(head == null) return null;

        Node cur = head;
        Deque<Node> queue = new LinkedList<>();

        while(!queue.isEmpty() || cur.next != null || cur.child != null){
            if(cur.child !=null){
                if(cur.next != null){
                    queue.push(cur.next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
                cur = cur.next;

            }else if(cur.next != null){
                cur.next.prev = cur;
                cur = cur.next;
            }else{
                cur.next = queue.poll();
                cur.next.prev = cur;
                cur = cur.next;
            }




        }
        return head;

    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
