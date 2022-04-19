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
    TreeNode last=null;
    TreeNode x=null;
    TreeNode xprev=null;
    TreeNode y=null;
    public void recur(TreeNode root){
        if(root==null)return ;
        recur(root.left);
        if(last==null){
            last=root;
        }else{
            if(last.val>root.val){
                //last=root;
                if(x==null){
                x=last;
                xprev=root;
                }
                else{
                    y=root;
                    int temp=y.val;
                    y.val=x.val;
                    x.val=temp;
                    return ;
                }
                
            }
            last=root;
        }
        recur(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        recur(root);
        if(y==null && x!=null){
            int temp=xprev.val;
                    xprev.val=x.val;
                    x.val=temp;
        }
    }
}