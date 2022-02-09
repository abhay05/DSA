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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
   TreeNode createBST(ListNode node,ListNode prev){
       
        if(node==null || node==prev)return null;
       
       ListNode head=node;
       ListNode nextNode=node;
       while(nextNode!=null && nextNode.next!=null && nextNode!=prev && nextNode.next!=prev){
           head=head.next;
           nextNode=nextNode.next.next;
       }
       
        TreeNode tnode=new TreeNode(head.val);
       ListNode newHead=head.next;
        tnode.left=createBST(node,head);
       if(newHead!=null){
        tnode.right=createBST(newHead,prev);
       }
        return tnode;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        return createBST(head,null);
    }
}