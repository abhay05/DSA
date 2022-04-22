class Node{
    int key;
    int val;
    Node left;
    Node right;
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
class MyHashMap {
    
    Node[] arr;
    int size;
    
    public void ins(Node head,Node newNode){
        int key=newNode.key;
        int val=newNode.val;
        Node temp=head;
        int exists=0;
        Node last=null;
        while(temp!=null){
            if(key<=temp.key){
                if(temp.key==key){
                    temp.val=val;
                    exists=1;
                }
                last=temp;
                temp=temp.left;
            }else{
                last=temp;
                temp=temp.right;
            }
        }
     //   System.out.println("ins " + last.key+" "+key);
        if(exists==0){
            if(last.key>key){
                last.left=newNode;
            }else if(last.key>key){
                last.right=newNode;
            }
        }
    }
    
    public int search(Node head,int key){
        Node curr=head;
        while(curr!=null){
            //System.out.println(curr.key);
            if(curr.key>=key){
                if(curr.key==key)return curr.val;
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
        return -1;
    }
    
    public void delete(Node head,int key){
        Node curr=head;
        Node deleteNode=null;
        Node parNode=this.arr[key%this.size];
        while(curr!=null){
            if(curr.key>=key){
                if(curr.key==key){ deleteNode=curr;break;
                                 }
                parNode=curr;
                curr=curr.left;
            }else{
                parNode=curr;
                curr=curr.right;
            }
        }
        if(deleteNode==null){
            return ;
        }else{
            Node right=deleteNode.right;
            if(right==null){
                if(parNode.left!=null && parNode.left.key==deleteNode.key){
                    parNode.left=deleteNode.left;
                    deleteNode.left=null;
                }else if(parNode.right!=null && parNode.right.key==deleteNode.key){
                    parNode.right=deleteNode.left;
                    deleteNode.left=null;
                }
                return ;
            }
           if(right.left==null){
               deleteNode.val=right.val;
               deleteNode.right=right.right;
               right.right=null;
               return ;
           }
            while(right.left.left!=null){
                right=right.left;
            }
            deleteNode.val=right.left.val;
            right.left=null;
        }
    }
    
    public MyHashMap() {
        this.size=100000;
        arr=new Node[this.size];
        for(int i=0;i<this.size;i++){
            arr[i]=new Node(i,-1);
        }
    }
    
    public void put(int key, int value) {
        int ind=key%this.size;
        Node newNode=new Node(key,value);
        if(arr[ind].left!=null){
            ins(arr[ind].left,newNode);
        }else{
            arr[ind].left=newNode;
        }
    }
    
    public int get(int key) {
        int ind=key%this.size;
        if(arr[ind].left==null)return -1;
        
       return search(arr[ind].left,key);
    }
    
    public void remove(int key) {
        int ind=key%this.size;
        if(arr[ind].left==null)return ;
        delete(arr[ind].left,key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */