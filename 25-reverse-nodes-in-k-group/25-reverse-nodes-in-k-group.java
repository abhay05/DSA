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
    public ListNode reverseKGroup(ListNode head, int k) {
        int i=0;
        ListNode curr=head;
        ListNode currNext=head;
        ListNode st=curr;
        ListNode newNode=null;
        ListNode ans=null;
        ListNode prevNode=null;
        while(curr!=null){
            st=curr;
            int currInt=k-1;
            while(currNext.next!=null && currInt!=0){
                currNext=currNext.next;
                currInt--;
            }
            if(currInt>0)break;
            newNode=currNext.next;
            ListNode newNext=newNode;
            while(curr!=newNode){
                ListNode temp=curr.next;
                curr.next=newNext;
                newNext=curr;
                curr=temp;
            }
            if(prevNode!=null){
                prevNode.next=currNext;
            }
            if(i==0){
                ans=currNext;
            }
            curr=newNode;
            currNext=newNode;
            prevNode=st;
            i++;
        }
        return ans;
    }
}