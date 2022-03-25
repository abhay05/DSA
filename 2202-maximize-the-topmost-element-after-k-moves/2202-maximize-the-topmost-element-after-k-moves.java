class Solution {
    public int maximumTop(int[] nums, int k) {
        int n=nums.length;
        int ans=-1;
        int cnt=0;
        for(int i=0;i<k-1&&i<n;i++){
            ans=Math.max(ans,nums[i]);
            cnt++;
        }
        if(nums.length==1){
            if(k%2==1){return -1;}
            else{return nums[0];}
        }
        int val1=(k+1<=n?nums[k]:-1);
        return Math.max(ans,val1);
    }
}