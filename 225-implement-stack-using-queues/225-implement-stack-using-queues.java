class MyStack {
    
    Queue<Integer>q=new LinkedList<Integer>();
    Queue<Integer>q1=new LinkedList<Integer>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int ans=-1;
        while(true){
        int qint=q.poll();
      //  System.out.println(qint);
        
        if(q.isEmpty()){
            ans=qint;
            break;
        }else{
            q1.add(qint);
        }
        }
        while(!q1.isEmpty()){
            q.add(q1.poll());
        }
        return ans;
    }
    
    public int top() {
        int ans=-1;
        while(true){
        int qint=q.poll();
        q1.add(qint);
        if(q.isEmpty()){
            ans=qint;
            break;
        }
        }
        while(!q1.isEmpty()){
            q.add(q1.poll());
        }
        return ans;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */