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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        int cnt=1;
        while(cnt!=k){
            curr=curr.next;
            cnt++;
        }
        ListNode node1=curr;
        ListNode currnow=head;
        while(curr.next!=null){
            currnow=currnow.next;
            curr=curr.next;
        }
        int val=currnow.val;
        currnow.val=node1.val;
        node1.val=val;
        return head;
    }
}