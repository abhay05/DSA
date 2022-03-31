class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(nums[slow]!=nums[fast]){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int ans=0;
        while(nums[slow]!=nums[ans]){
            slow=nums[slow];
            ans=nums[ans];
        }
        return nums[ans];
    }
}