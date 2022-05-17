/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode recur(TreeNode cloned,TreeNode target){
        if(cloned==null)return null;
        TreeNode left=null,right=null;
        if(cloned.left!=null)
        {left=recur(cloned.left,target);}
        if(target.val==cloned.val)return cloned;
        if(cloned.right!=null){
            right=recur(cloned.right,target);}
        return left==null?right:left;
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return recur(cloned,target);
    }
}