class MyHashSet {
	
	int capacity=30;
	double load_factor=0.9;
	BstNode array[];
	int size=0;
	
    public MyHashSet() {
	this.array=new BstNode[this.capacity];
        for(int i=0;i<this.capacity;i++){
			this.array[i]=new BstNode();
		}
    }
    
    public void add(int key) {
        int ind=calculateHash(key,this.capacity);
        if(this.array[ind].head==null){this.size++;}
		this.array[ind].add(this.array[ind].getHead(),key);
		if(this.size>0.9*this.capacity){
			resetTree();
		}
    }
    
    public void remove(int key) {
        int ind=calculateHash(key,this.capacity);
        if(this.array[ind]!=null){
		this.array[ind].head=this.array[ind].remove(this.array[ind].getHead(),key);}
		this.size--;
    }
    
    public boolean contains(int key) {
        int ind=calculateHash(key,this.capacity);
		if(this.array[ind]!=null && this.array[ind].getHead()!=null){
		return this.array[ind].contains(this.array[ind].getHead(),key);}
		return false;
    }
	
	public int calculateHash(int key,int div){
		return key%div;
	}
	
	public void resetTree(){
		BstNode[] newArray=new BstNode[2*this.capacity];
		for(int i=0;i<2*this.capacity;i++){
			newArray[i]=new BstNode();
		}
        
		for(BstNode node:this.array){
            if(node!=null){
			List<Node> nodes=node.getAllTheNodes();
			for(Node e:nodes){
				int hashValue=calculateHash(e.key,this.capacity);
                int nhashValue=calculateHash(e.key,2*this.capacity);
				newArray[nhashValue].add(this.array[hashValue].getHead(),e.key);
			}
            }
		}
		this.capacity=2*this.capacity;
		this.array=newArray;
	}
}

class Node{
	int key;
	int val;
	Node left;
	Node right;
	Node(int key){
		this.key=key;
		this.val=0;
		this.left=null;
		this.right=null;
	}
}

class BstNode{
	Node head;
	
	public void BstNode(){
		this.head=null;
	}
	
	public Node getHead(){
		return this.head;
	}
	
	public void add(Node node,int key){
		if(this.head==null){
			this.head=new Node(key);
			return ;
		}
		if(node.left==null && node.key>key){
			node.left=new Node(key);
			return ;
		}
		else if(node.right==null && node.key<key){
			node.right=new Node(key);
			return ;
		}
		else{
			if(node.key>key){
				add(node.left,key);
			}
			else if(node.key<key){
				add(node.right,key);
			}
		}
	}
	
	public List<Node> getAllTheNodes(){
        if(this.head==null) return new ArrayList<Node>();
		List<Node> list=new ArrayList<Node>();
		Node headn=this.head;
		list.add(this.head);
		Queue<Node> queue=new LinkedList<>();
		queue.add(headn);
		while(queue.size()>0){
			Node temp=queue.poll();
			//temp.left;
			if(temp.left!=null){
				queue.add(temp.left);
				list.add(temp.left);
			}
			if(temp.right!=null){
				queue.add(temp.right);
				list.add(temp.right);
			}
		}
		return list;
	}
	
	public Node remove(Node node,int key){
		if(node==null) return null;
		if(node.key>key){
			node.left=remove(node.left,key);
            
		}
		else if(node.key<key){
			node.right=remove(node.right,key);
		}else{
			if(node.left==null){
				node= node.right;
                return node;
			}
			if(node.right==null){
				node= node.left;
                return node;
			}
			int val=getMinValue(node.right);
     
			node.right=remove(node.right,val);
			node.key=val;
		}
		return node;
	}
	
	public int getMinValue(Node node){
		if(node.left==null){
        
			return node.key;
		}
		return	getMinValue(node.left);
		
	}
	
	public boolean contains(Node node,int key){
		if(node==null)return false;
		boolean b1=false;
		boolean b2=false;
		if(node.key>key){
			b1=this.contains(node.left,key);
		}
		else if(node.key<key){
			b2=this.contains(node.right,key);
		}else{
			return true;
		}
   
		return (b1|b2);
	}
}