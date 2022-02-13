class Node{
    int val;
    Node prev;
    Node next;
    Node up;
    Node down;
    Node(int val){
        this.val=val;
        this.prev=null;
        this.next=null;
        this.up=null;
        this.down=null;
    }
}

class Skiplist {
    
    Node head;
    int count;
    public Skiplist() {
        this.head = new Node(-1);
        this.count=0;
    }
    
    public void print(int num){
        System.out.println("New node");
        Node curr=head;
        Node curra=curr;
        while(curr!=null){
        while(curra!=null){
            System.out.print(curra.val);
            System.out.print(" ");
            curra=curra.next;
        }
            
        System.out.println();
        curra=curr.down;
        curr=curr.down;
    }
    }
    
    public boolean search(int target) {
        Node prev=null;
        Node curr=this.head;
        while(curr!=null){
        while(curr.next!=null && target>curr.val){
            curr=curr.next;
        }
        if(target==curr.val){
            return true;
        }else{
            if(curr.val>target){
            curr=curr.prev;}
            curr=curr.down;
        }
        }
        return false;
    }
    
    public void add(int num) {
        Node newNode=new Node(num);
        Node prev=null;
        Node curr=this.head;
        while(curr.down!=null){
            while(curr.next!=null && num>curr.val){
            curr=curr.next;
            }
            if(num<curr.val){
            curr=curr.prev;}
            curr=curr.down;
        }
        while(curr.next!=null && num>curr.val){
            curr=curr.next;
        }
        if(num<curr.val){
            curr=curr.prev;
            
        }
        newNode.next=curr.next;
        newNode.prev=curr;
        curr.next=newNode;
        if(newNode.next!=null){
        newNode.next.prev=newNode;}
        Node downNode=newNode;
        this.count++;
        int ind=this.count;
        int height=0;
        curr=this.head;
        while(curr.down!=null){
            curr=curr.down;
        }
        while(curr!=null && ind%2==0){
            ind/=2;
            height++;
            Node oneHeadup=curr.up;
            if(oneHeadup!=null){
                Node checkJustSmaller=oneHeadup;
                while(checkJustSmaller.next!=null && checkJustSmaller.val<num){
                    checkJustSmaller=checkJustSmaller.next;
                }
                if(checkJustSmaller.val>num){
                    checkJustSmaller=checkJustSmaller.prev;
                }
                newNode=new Node(num);
                newNode.next=checkJustSmaller.next;
                newNode.prev=checkJustSmaller;
                newNode.down=downNode;
                downNode.up=newNode;
                checkJustSmaller.next=newNode;
                if(newNode.next!=null){
                newNode.next.prev=newNode;}
            }
            else{
            oneHeadup=new Node(-1);
            oneHeadup.down=curr;
            curr.up=oneHeadup;
            curr=curr.up;
            curr.next=new Node(num);
            curr.next.down=downNode;
            downNode.up=curr.next;
            curr.next.prev=curr;
                this.head=curr;
            }
            
            curr=curr.up;
            downNode=downNode.up;
        }
        
        //print(num);
        
    }
    
    public boolean erase(int num) {
        Node curr=this.head;
        while(curr.down!=null){
            while(curr.next!=null && num>curr.val){
            curr=curr.next;
            }
            if(curr.val>num){
            curr=curr.prev;}
            curr=curr.down;
        }
        while(curr.next!=null && num>curr.val){
            curr=curr.next;
        }
        if(curr.val>num){
            curr=curr.prev;}
        if(num==curr.val){
            while(curr!=null){
                curr.prev.next=curr.next;
                if(curr.next!=null){
                curr.next.prev=curr.prev;}
                curr.next=null;
                curr.prev=null;
                curr=curr.up;
            }
          //  print();
            return true;
        }
        return false;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */