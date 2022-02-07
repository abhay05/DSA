/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/



class Solution {
    Node recur(Node head){
    
    Node childEnd=null;
    if(head.child!=null){
       // System.out.println(head.child.val);
       childEnd= recur(head.child);
        if(head.next!=null){
        childEnd.next=head.next;
        head.next.prev=childEnd;}
        head.next=head.child;
        head.child.prev=head;
        head.child=null;
    }
        if(head.next==null){
        return head;
    }
    Node listEnd=recur(head.next);
    return listEnd;
    
}
    public Node flatten(Node head) {
        if(head==null)return head;
     //   System.out.println(head.val);
        Node heada=head;
        Node listEnd= recur(head);
     //   System.out.println(listEnd.val);
        return heada;
    }
}