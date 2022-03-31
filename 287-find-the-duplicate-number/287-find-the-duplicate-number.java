class Solution {
    public int findDuplicate(int[] nums) {
        int l=1;
        int u=nums.length-1;
        int ans=-1;
        while(l<u){
            int mid=(l+u)/2;
            int cnt=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){
                u=mid;
            }
            else{
                l=mid+1;
            }
            
            
        }
        return l;
    }
}