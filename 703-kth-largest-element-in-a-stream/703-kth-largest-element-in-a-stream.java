class KthLargest {
    List<Integer> arlist=new ArrayList<>();
    int ind=0;
    int k;
    public int find(List<Integer>list,int val){
        int l=0;
        int u=list.size()-1;
        while(l<=u){
            int mid=(l+u)/2;
            if(list.get(mid)<=val){
                l=mid+1;
            }
            else{
                u=mid-1;
            }
        }
        return l;
    }
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k=k;
        for(int i=0;i<nums.length;i++){
            this.arlist.add(nums[i]);
        }
        
        this.ind=this.arlist.size()-k;
    }
    
    public int add(int val) {
        int indi=find(this.arlist,val);
        this.arlist.add(indi,val);
        // for(int i=0;i<this.arlist.size();i++){
        //         if(val<=this.arlist.get(i)){
        //             this.arlist.add(i,val);
        //             break;
        //         }
        //     }
            if(this.arlist.size()==0||val>this.arlist.get(this.arlist.size()-1)){
                this.arlist.add(val);
            }
        return this.arlist.get(this.arlist.size()-this.k);
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */