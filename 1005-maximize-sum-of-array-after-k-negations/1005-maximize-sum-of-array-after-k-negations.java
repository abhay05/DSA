class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && k>0){
                nums[i]*=(-1);
                k--;
            }else{
                break;
            }
        }
        Arrays.sort(nums);
        nums[0]=nums[0]*(k%2==1?-1:1);
        for(int i=0;i<nums.length;i++){
            ans+=nums[i];
        }
        return ans;
    }
}