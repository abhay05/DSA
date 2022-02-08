/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) { 
        if(root==null)return root;
        root.next=null;
        Node node=root;
        Node future=null;
        while(node!=null){
            Node child=null;
            
            while(node!=null){
                if(child==null){
                    if(node.left!=null){
                    child=node.left;
                    future=child;
                    }
                    else if(node.right!=null){
                        child=node.right;
                        future=child;
                    }
                }
                    if(child!=node.left && child!=node.right){
                        if(node.left!=null){
                        child.next=node.left;
                        child=child.next;
                        }
                        else if(node.right!=null){
                            child.next=node.right;
                            child=child.next;
                        }
                    } 
                   if(node.left!=null && child==node.left){
                        if(node.right!=null){
                            child.next=node.right;
                            child=child.next;
                        }
                    }
                node=node.next;
            }
            node=future;
            future=null;
        }
        return root;
    }
}