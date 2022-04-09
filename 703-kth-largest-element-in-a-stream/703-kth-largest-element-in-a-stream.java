class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int a:nums){
            add(a);
        }
    }
    
    public int add(int val) {
        if(this.pq.size()<this.k){
            this.pq.offer(val);
        }else if(this.pq.peek()<val){
            this.pq.poll();
            this.pq.offer(val);
        }
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */