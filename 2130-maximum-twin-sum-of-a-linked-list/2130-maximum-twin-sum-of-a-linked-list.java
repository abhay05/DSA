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
    public int pairSum(ListNode head) {
        int n=0;
        ListNode headA=head;
        while(head!=null){
            n++;
            head=head.next;
        }
        int cnt=0;
        ListNode prev=null;
        head=headA;
        while(head!=null){
            cnt++;
            
            if(cnt>=n/2){
                ListNode temp=head;
                head=head.next;
                temp.next=prev;
                prev=temp;
            }else{
                prev=head;
            head=head.next;
            }
            
        }
        head=headA;
        int maxSum=0;
         cnt=0;
        while(cnt<n/2){
            cnt++;
            maxSum=Math.max(maxSum,head.val+prev.val);
            head=head.next;
            prev=prev.next;
        }
        return maxSum;
    }
}