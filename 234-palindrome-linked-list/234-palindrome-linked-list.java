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
    public boolean isPalindrome(ListNode head) {
        int n=0;
        ListNode heada=head;
        while(head!=null){
            head=head.next;
            n++;
        }
        int mid=n/2;
        ListNode temp=heada;
        ListNode prev=null;
       // mid--;
        ListNode tempB=null;
        while(mid!=0){
            ListNode t=temp.next;
            temp.next=prev;
            prev=temp;
            temp=t;
            mid--;
        }
        if(n%2==1){
            tempB=temp.next;
        }else{
            tempB=temp;
        }
        while(prev!=null && tempB!=null){
            if(prev.val!=tempB.val)return false;
            prev=prev.next;
            tempB=tempB.next;
        }
        if(prev==null && tempB==null){
            return true;
        }
        return false;
    }
}