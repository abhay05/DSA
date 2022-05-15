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
    Map<Integer,Integer>mp=new HashMap<Integer,Integer>();
    void recur(TreeNode root,int level){
        if(root==null)return;
        if(root.left!=null){
            recur(root.left,level+1);
        }
        if(!mp.containsKey(level)){
            mp.put(level,root.val);
        }else{
            int valx=mp.get(level);
            mp.put(level,valx+root.val);
        }
       // System.out.println(level+" "+root.val);
        if(root.right!=null){
            recur(root.right,level+1);
        }
        return ;
        
    }
    public int deepestLeavesSum(TreeNode root) {
        recur(root,0);
        int val=0;
        int ans=0;
        for(Map.Entry<Integer,Integer>pr:mp.entrySet()){
            if(pr.getKey()>val){
                ans=pr.getValue();
                val=pr.getKey();
            }
        }
        return ans;
    }
}