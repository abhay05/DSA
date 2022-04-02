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
class BSTIterator {
    List<Integer> list;
    int ind;
    
    public BSTIterator(TreeNode root) {
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
        
        this.list= list;
        this.ind=0;
    }
    
    public int next() {
        this.ind++;
        return this.list.get(this.ind-1);
    }
    
    public boolean hasNext() {
        return this.ind<this.list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */