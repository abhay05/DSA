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

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<TreeNode>();
        if(root!=null)q.add(root);
       int res=0,i=0;
        while(q.size()>0){
            
        for( i=q.size()-1,res=0;i>=0;i--){
             root=q.poll();
            res+=root.val;
            if(root.right!=null)q.add(root.right);
            if(root.left!=null)q.add(root.left);
        }
        }
        return res;
    }
}