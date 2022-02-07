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
    public void flatten(TreeNode root) {
        TreeNode roota=root;
        while(root!=null){
            if(root.left!=null){
                TreeNode leftNode=root.left;
                while(leftNode.right!=null){
                    leftNode=leftNode.right;
                }
                leftNode.right=root.right;
                root.right=root.left;
                root.left=null;
            }
            root=root.right;
        }
        root=roota;
        //return roota;
    }
}