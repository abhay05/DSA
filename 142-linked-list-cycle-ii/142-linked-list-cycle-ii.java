/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode heada=head;
        ListNode headb=head;
        heada=head.next;
        headb=head.next.next;
        int f=0;
        while(heada!=null && headb!=null && headb.next!=null){
            heada=heada.next;
            headb=headb.next.next;
            if(heada==headb){
                f=1;
                break;
            }
        }
        if(f==0){return null;}
        ListNode headT=head;
        while(headT!=heada){
            headT=headT.next;
            heada=heada.next;
        }
        return headT;
        
    }
}