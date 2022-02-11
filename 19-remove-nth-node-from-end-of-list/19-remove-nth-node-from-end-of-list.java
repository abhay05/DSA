/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        ListNode heada=head;
        int cnt=n-1;
        while(cnt!=0){
            heada=heada.next;
            cnt--;
        }
        ListNode headb=head;
        ListNode prev=null;
        while(heada.next!=null){
            prev=headb;
            headb=headb.next;
            heada=heada.next;
        }
        if(prev!=null){
        prev.next=headb.next;}
        else{return head.next;}
        return head;
    }
}