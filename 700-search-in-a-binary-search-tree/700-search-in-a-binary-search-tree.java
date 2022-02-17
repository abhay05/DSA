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
    public TreeNode contains(TreeNode node,int key){
		if(node==null)return null;
		TreeNode b1=null;
		TreeNode b2=null;
		if(node.val>key){
			b1=this.contains(node.left,key);
		}
		else if(node.val<key){
			b2=this.contains(node.right,key);
		}else{
			return node;
		}
        if(b1==null && b2==null){
            return null;
        }
		return b1==null?b2:b1;
	}
    public TreeNode searchBST(TreeNode root, int val) {
        return contains(root,val);
    }
}