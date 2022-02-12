


class Node{
    Integer key;
    Integer val;
    Node next;
    Node prev;
    Node(Integer key,Integer val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}

class LRUCache {
    
    HashMap<Integer,Node> hp= new HashMap<Integer,Node>();    
    int capacity;
    Node head;
    Node last;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new Node(-1,-1);
        this.last=this.head;
    }
    
    public int get(int key) {
        if(this.hp.containsKey(key)){
            Node found=this.hp.get(key);
            
            if(found!=this.last){
            Node prevN=found.prev;
            prevN.next=prevN.next.next;
            found.next.prev=prevN;
            this.last.next=found;
            found.prev=this.last;
            this.last=this.last.next;
            this.last.next=null;
            found=this.last;
            }
            return found.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.hp.containsKey(key)){
            Node found=this.hp.get(key);
            if(found!=this.last){
            found.prev.next=found.next;
            found.next.prev=found.prev;
            this.last.next=found;
            found.prev=this.last;
			found.next=null;
            this.last=found;}
            found.val=value;
        }
        else if(this.hp.size()<this.capacity){
            Node node=new Node(key,value);
            this.hp.put(key,node);
            this.last.next=node;
            node.prev=this.last;
            this.last=this.last.next;
        }
        else{
            this.hp.remove(this.head.next.key);
            
            this.last.next=new Node(key,value);
            this.last.next.prev=this.last;
            this.last=this.last.next;
            this.hp.put(key,this.last);
            this.head.next.prev=null;
            if(this.head.next.next!=null){
            this.head.next.next.prev=this.head;}
            this.head.next=this.head.next.next;
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */