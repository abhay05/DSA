class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        long long sum=0;
        int n=nums.size();
        for(int i=0;i<n;i++){
        if(nums[i]>0){sum+=(long long)nums[i];}
            else{
                nums[i]=abs(nums[i]);
            }
        }
       // cout<<"sum "<<sum<<'\n';
        sort(nums.begin(),nums.end());
        int i=0;
        int l=0;
        priority_queue<pair<long long,int>>pq;
        pq.push({(long long)sum,0});
        
        while(1){
           pair<long long,int> pp=pq.top();
            pq.pop();
            long long val=pp.first;
            int i=pp.second;
            l++;
            //cout<<l<<' '<<val<<' '<<i<<'\n';
            if(l==k){
                return val;
            }
            if(i==0){
                pq.push({val-(long long)nums[i],i+1});
                //pq.push({val,i+1});
              
            }else{
                if(i<n){
                pq.push({val-(long long)nums[i],i+1});
                pq.push({val+(long long)nums[i-1]-(long long)nums[i],i+1});
                    
              // cout<<val-nums[i]<<' '<<val+nums[i-1]-nums[i]<<" hh \n";
                }
            }
        }
        return -1;
    }
};