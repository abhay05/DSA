class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int ind=0;
        int l=0;
        int u=n-1;
        while(l<u){
            int mid=(l+u)/2;
            if(nums[mid]>nums[u]){
                l=mid+1;
            }else if(nums[mid]<nums[u]){
                
                u=mid;
            }
        }
       // System.out.println(nums[u]);
        return nums[u];
    }
}