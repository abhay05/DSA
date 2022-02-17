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
    
    public TreeNode remove(TreeNode node,int key){
		if(node==null) return null;
		if(node.val>key){
			node.left=remove(node.left,key);
            
		}
		else if(node.val<key){
			node.right=remove(node.right,key);
		}else{
			if(node.left==null){
				node= node.right;
                return node;
			}
			if(node.right==null){
				node= node.left;
                return node;
			}
			int val=getMinValue(node.right);
     
			node.right=remove(node.right,val);
			node.val=val;
		}
		return node;
	}
    
    public int getMinValue(TreeNode node){
		if(node.left==null){
        
			return node.val;
		}
		return	getMinValue(node.left);
		
	}
    
    public TreeNode deleteNode(TreeNode root, int key) {
        root=remove(root,key);
        return root;
    }
}