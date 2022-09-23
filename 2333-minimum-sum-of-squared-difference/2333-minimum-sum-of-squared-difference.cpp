class Solution {
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        long long ans=0;
        int t=k1+k2;
        int arr[100001];
        int n=nums1.size();
        for(int i=0;i<100001;i++){
            arr[i]=0;
        }
        for(int i=0;i<n;i++){
            arr[abs(nums1[i]-nums2[i])]++;
        }
        
        for(int i=100000;i>0;i--){
            if(t<=0)break;
            int val=min(t,arr[i]);
            if(t>val){
                t-=val;
                arr[i-1]+=arr[i];
                arr[i]=0;
            }else{
                arr[i-1]+=t;
                arr[i]-=t;
                t=0;
            }
            
        }
        
        for(int i=0;i<=100000;i++){
            ans+=(long long)i*(long long)i*(long long)arr[i];
        }
        
        return ans;
        
    }
};