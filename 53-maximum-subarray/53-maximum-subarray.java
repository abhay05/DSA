class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int n=nums.length;
        int temp=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=temp+nums[i]){
                temp=nums[i];
            }else{
                temp+=nums[i];
            }
            sum=Math.max(sum,temp);
        }
        return sum;
    }
}