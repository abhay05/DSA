/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headAt=headA;
        ListNode headBt=headB;
        int l1=0;
        int l2=0;
        
        while(headA!=null){
            l1++;
            headA=headA.next;
        }
        while(headB!=null){
            l2++;
            headB=headB.next;
        }
        int cnt=Math.abs(l1-l2);
        headA=headAt;
        headB=headBt;    
        if(l1>l2){
            while(cnt>0){
            headA=headA.next;
            cnt--;}
        }else if(l2>l1){
            while(cnt>0){
                headB=headB.next;
                cnt--;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}