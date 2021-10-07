package LC;

public class lc725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if(head == null) return res;

        int l = 0;
        ListNode tmp = head;
        while(tmp != null){
            l++;
            tmp = tmp.next;
        }

        int div = l / k; // 每个里面至少有几个
        int mod = l % k; // 前mod个需要+1
        tmp = head;
        for(int i=0; i<k; i++){
            ListNode tHead = new ListNode();
            int num = div;
            if(mod > 0){
                num++;
                mod--;
            }

            if(num == 0){
                res[i] = null;
            }else{
                // 至少有一个
                tHead.val = tmp.val;
                ListNode cur = tHead;
                tmp = tmp.next;

                num--;
                while(num>0){
                    ListNode tNode = new ListNode(tmp.val);
                    cur.next = tNode;
                    cur = cur.next;
                    tmp = tmp.next;
                }

                res[i] = tHead;

            }

        }
        return res;


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}