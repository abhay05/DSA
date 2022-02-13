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
    
    ListNode merge(ListNode a, ListNode b){
        ListNode head=new ListNode(-1);
        ListNode ans=head;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                ListNode newNode= new ListNode(a.val);
                head.next=newNode;
                head=head.next;
                a=a.next;
            }else{
                ListNode newNode=new ListNode(b.val);
                head.next=newNode;
                head=head.next;
                b=b.next;
            }
        }
        while(a!=null){
            ListNode newNode= new ListNode(a.val);
                head.next=newNode;
                head=head.next;
                a=a.next;
        }
        while(b!=null){
            ListNode newNode=new ListNode(b.val);
                head.next=newNode;
                head=head.next;
                b=b.next;
        }
        return ans.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        ListNode ans=merge(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            ans=merge(ans,lists[i]);
        }
        return ans;
    }
}