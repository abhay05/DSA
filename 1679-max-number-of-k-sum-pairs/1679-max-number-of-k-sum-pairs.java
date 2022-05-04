class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0;
        int u=n-1;
        int ans=0;
        while(l<u){
            if(nums[l]+nums[u]==k){
                ans++;
                l++;
                u--;
            }else if(nums[l]+nums[u]>k){
                u--;
            }else{
                l++;
            }
        }
        return ans;
    }
}