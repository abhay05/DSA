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
    
    public boolean match(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        if(root.val!=subRoot.val)return false;
        return (match(root.left,subRoot.left) && match(root.right,subRoot.right));
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        boolean matchBool=false;
        if(root.val==subRoot.val){matchBool= match(root,subRoot);}
        return (matchBool | isSubtree(root.left,subRoot) | isSubtree(root.right,subRoot));
    }
}