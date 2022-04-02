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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> list=new ArrayList<Integer>();
        while(stack.size()>0){
            root=stack.pop();
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.empty()){
            root=stack.pop();
            list.add(root.val);
            }
            while(root!=null && root.right==null && !stack.empty()){
                root=stack.pop();
                list.add(root.val);
                
            }
            if(root!=null){
            root=root.right;}
            if(root!=null){
            stack.push(root);}
        }
        
        return list;
    }
}