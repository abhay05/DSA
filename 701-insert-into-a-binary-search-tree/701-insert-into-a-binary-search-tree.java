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
    
    public TreeNode add(TreeNode node,int key){
		if(node==null){ 
			node=new TreeNode(key);
			return node;
		}
		if(node.left==null && node.val>key){
			node.left=new TreeNode(key);
			return node;
		}
		else if(node.right==null && node.val<key){
			node.right=new TreeNode(key);
			return node;
		}
		else{
			if(node.val>key){
				add(node.left,key);
			}
			else if(node.val<key){
				add(node.right,key);
			}
		}
        return node;
	}
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
       return add(root,val);
         
    }
}