package Week_01;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/2 19:12
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int x) { val = x; }
    ListNode(int x,ListNode next) { this.val = x; this.next = next; }
}
public class SolutionOfMergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        } else if (l2 == null){
            return l1;
        } else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
