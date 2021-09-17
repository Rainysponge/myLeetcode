package LC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc138 {

    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if(!map.containsKey(head)){
            Node t = new Node(head.val);

            map.put(head, t);  // head 存原来第节点， t是深拷贝的节点

            t.next = copyRandomList(head.next);
            t.random = copyRandomList(head.random);



        }

        return map.get(head);

    }


}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}