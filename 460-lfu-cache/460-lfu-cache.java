class Node{
    int key;
    int val;
    int cnt;
    Node next;
    Node prev;
    Node(int key,int val,int cnt){
        this.key=key;
        this.val=val;
        this.cnt=cnt;
        this.next=null;
    }
    
    void setCnt(int cnt){
        this.cnt=cnt;
    }
    void setVal(int value){
        this.val=value;
    }
}

class LFUCache {
    
    HashMap<Integer,Node> cache;
    HashMap<Integer,Node> cntCache;
    int capacity;
    Node head;
    Node tail;
    
    public LFUCache(int capacity) {
        this.head=new Node(-1,-1,1);
        this.tail=this.head;
        this.capacity=capacity;
        this.cache=new HashMap<Integer,Node>();
        this.cntCache = new HashMap<Integer,Node>();
        this.cntCache.put(1,this.head);
    }
    
    public int get(int key) {
        if(cache.get(key)!=null){
            Node newNode = cache.get(key);
            int cnt=newNode.cnt+1;
            
			Node checkNode=cntCache.get(newNode.cnt);
			
			if(checkNode==newNode){
			cntCache.remove(newNode.cnt);
			}
            if(newNode.prev.cnt==newNode.cnt && newNode==checkNode){
                cntCache.put(newNode.prev.cnt,newNode.prev);
            }
			newNode.setCnt(cnt);
            Node node = cntCache.get(cnt);
            if(node==null){
                node=cntCache.get(cnt-1);
            }
            if(node!=null && node!=newNode){
           
             newNode.prev.next=newNode.next;
            if(newNode.next!=null){
             newNode.next.prev=newNode.prev;}
             newNode.next=node.next;
             newNode.prev=node;
             if(node.next!=null){
             node.next.prev=newNode;}
             node.next=newNode;
            }
            cntCache.put(newNode.cnt,newNode);
            
            return newNode.val;  
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.get(key)!=null){
            Node newNode = cache.get(key);
            int cnt=newNode.cnt+1;
            
			Node checkNode=cntCache.get(newNode.cnt);
			
			if(checkNode==newNode){
			cntCache.remove(newNode.cnt);
			}
            if(newNode.prev.cnt==newNode.cnt && newNode==checkNode){
                cntCache.put(newNode.prev.cnt,newNode.prev);
            }
			newNode.setCnt(cnt);
            newNode.setVal(value);
            Node node = cntCache.get(cnt);
            
            if(node==null){
                node=cntCache.get(cnt-1);
            }
            
            if(node!=null){
             newNode.prev.next=newNode.next;
                if(newNode.next!=null){
             newNode.next.prev=newNode.prev;}
             newNode.next=node.next;
             newNode.prev=node;
             if(node.next!=null){
             node.next.prev=newNode;}
             node.next=newNode;
            }
            cache.put(key,newNode);
            cntCache.put(cnt,newNode);
            
        }else if(cache.size()<this.capacity){
            Node newNode = new Node(key,value,1);
           // cntCache.put(1,newNode);
            Node node = cntCache.get(1);
            cache.put(key,newNode);
            newNode.next=node.next;
            newNode.prev=node;
            if(node.next!=null){
            node.next.prev=newNode;}
            node.next=newNode;
            cntCache.put(1,newNode);
        }else{
            Node deleteNode=this.head.next;
            if(deleteNode==null){return ;}
          //  if(deleteNode.cnt>1)return ;
            if(this.head.next.next!=null){
            this.head.next.next.prev=this.head;}
            this.head.next=this.head.next.next;
            cache.remove(deleteNode.key,deleteNode);
            if(cntCache.get(deleteNode.cnt)==deleteNode){
                cntCache.remove(deleteNode.cnt);
                if(deleteNode.cnt==1){
                    cntCache.put(1,this.head);
                }
            }
            deleteNode.next=null;
            deleteNode.prev=null;
            
            Node newNode = new Node(key,value,1);
           // cntCache.put(1,newNode);
            Node node = cntCache.get(1);
            cache.put(key,newNode);
            newNode.next=node.next;
            newNode.prev=node;
            if(node.next!=null){
            node.next.prev=newNode;}
            node.next=newNode;
            cntCache.put(1,newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */