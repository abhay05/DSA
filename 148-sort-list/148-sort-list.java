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
    
    ListNode mergeSort(ListNode node,int l, int u){
    
    if(l==u){
        return node;
    }
    
    int mid=(l+u)/2;
    
    ListNode temp=node;
    int cnt=l;
    while(cnt<=mid && temp!=null){
        temp=temp.next;
        cnt++;
    } 
    
    return merge(mergeSort(node,l,mid),mergeSort(temp,mid+1,u),l,mid,u);
}

ListNode merge(ListNode left,ListNode right,int l,int mid,int u){
    ListNode ans=new ListNode(-1);
    ListNode ans1=ans;
    int l1=l;
    int u1=mid+1;
    while(l1<=mid && u1<=u && left!=null && right!=null){
        if(left.val<right.val){
        ListNode newNode=new ListNode(left.val);
        ans.next=newNode;
        ans=ans.next;
        left=left.next;
        l1++;
        }
        else{
        ListNode newNode=new ListNode(right.val);
        ans.next=newNode;
        ans=ans.next;
        right=right.next;
        u1++;
        }
    }
    while(l1<=mid && left!=null){
        ListNode newNode=new ListNode(left.val);
        ans.next=newNode;
        ans=ans.next;
        left=left.next;
        l1++;
    }
    while(u1<=u && right!=null){
        ListNode newNode=new ListNode(right.val);
        ans.next=newNode;
        ans=ans.next;
        right=right.next;
        u1++;
    }
    return ans1.next;
}
    
    public ListNode sortList(ListNode head) {
        if(head==null)return head;
        int n=0;
        ListNode heada=head;
        while(head!=null){
            head=head.next;
            n++;
        }
        head=heada;
        return mergeSort(head,1,n);
     //   return heada;
    }
}