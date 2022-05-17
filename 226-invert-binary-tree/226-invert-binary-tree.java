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
    
    public void recur(TreeNode root){
        if(root==null)return;
        if(root.left!=null)recur(root.left);
        if(root.right!=null)recur(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
    
    public TreeNode invertTree(TreeNode root) {
        recur(root);
        return root;
    }
}