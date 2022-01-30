class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int u=n-1;
        int end=-1;
        int st=-1;
        while(l<=u){
            int m=(l+u)/2;
            if(nums[m]<=target){
                l=m+1;
                if(nums[m]==target){
                end=m;}
            }else{
                u=m-1;
            }
        }
        l=0;
        u=n-1;
        while(l<=u){
            int m=(l+u)/2;
            if(nums[m]<target){
                l=m+1;
                
            }else{
                u=m-1;
                if(nums[m]==target){
                st=m;}
            }
        }
        return new int[]{st,end};
    }
}