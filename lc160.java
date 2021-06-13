package LC;

public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa = headA, pb = headB;
        boolean fa = false, fb = false;
        while(pa==null){
            if(pa == pb) return pa;
            if(pa.next == null && !fa){
                pa = headB;
                fa = true;
            }else{
                pa = pa.next;
            }
            if(pb == null && !fb){
                pb = headA;
                fb = true;
            }else{
                pb = pb.next;
            }


        }
        return null;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
