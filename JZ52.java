package LC;

public class JZ52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        if(a == null || b == null) return null;
        boolean aBoolean = false;   // 判断a是否将a已经遍历完
        boolean bBoolean = false;   // 判断b是否将b已经遍历完


        while(a != null && b != null){
            if(a == b){
                return a;
            }

            a = a.next;
            b = b.next;

            if(!aBoolean && a == null){
                a = headB;
                aBoolean = true;
            }

            if(!bBoolean &&   b == null){
                b = headA;
                bBoolean = true;
            }


        }


        return null;

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}