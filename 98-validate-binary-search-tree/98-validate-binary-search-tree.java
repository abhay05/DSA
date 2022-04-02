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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> list=new ArrayList<Integer>();
        while(stack.size()>0){
            root=stack.pop();
            while(root!=null){
                stack.push(root);
                if(root.left!=null && root.left.val>=root.val){
                    return false;
                }
                root=root.left;
            }
            if(!stack.empty()){
            root=stack.pop();
            if(list.size()>0 && root.val<=list.get(list.size()-1))return false;
            list.add(root.val);
            }
            while(root!=null && root.right==null && !stack.empty()){
                root=stack.pop();
                if(root.val<=list.get(list.size()-1))return false;
                list.add(root.val);
                
            }
            if(root!=null && root.right!=null && root.val>=root.right.val){
                return false;
            }
            if(root!=null && root.right !=null && root.right.left!=null && root.right.left.val<=root.val){
                return false;
            }
            if(root!=null){
            root=root.right;}
            if(!stack.empty()){
            TreeNode top=stack.peek();
            if(top!=null && top.val<=root.val){return false;}
            }
            if(root!=null){
            stack.push(root);}
        }
        
        return true;
        
    }
    
}