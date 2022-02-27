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
    
    List<TreeNode> getAllTrees(int st,int end){
        if(st>end){
            TreeNode newNode=new TreeNode(-1);
            List<TreeNode> li= new ArrayList<TreeNode>();
            li.add(newNode);
            return li;
        }
        if(st==end){
            TreeNode newNode=new TreeNode(st);
            List<TreeNode> li=new ArrayList<TreeNode>();
            li.add(newNode);
            return li;
        }
        List<TreeNode> ans=new ArrayList<TreeNode>();
        for(int i=st;i<=end;i++){
            List<TreeNode> v1=getAllTrees(i+1,end);
            List<TreeNode> v2=getAllTrees(st,i-1);
            
            for(int l=0;l<v2.size();l++){
                for(int j=0;j<v1.size();j++){
                    TreeNode left=v2.get(l);
                    TreeNode right=v1.get(j);
                    TreeNode newNode=new TreeNode(i);
                    if(left.val>0){
                        newNode.left=left;
                    }
                    if(right.val>0){
                        newNode.right=right;
                    }
                    ans.add(newNode);
                }
            }
            
        }
        return ans;
    }
    
    public List<TreeNode> generateTrees(int n) {
        return getAllTrees(1,n);
    }
}