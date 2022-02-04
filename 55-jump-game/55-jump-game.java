class Solution {
    public boolean canJump(int[] nums) {
        int curr=0;
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxL){
                return false;
            }
            if(i>curr){
                curr=maxL;
            }
            maxL=Math.max(maxL,nums[i]+i);
            
        }
        return true;
    }
}