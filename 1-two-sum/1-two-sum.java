class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans={};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    int[] temp={i,j};
                    ans= temp;
                }
            }
        }
        return ans;
    }
}