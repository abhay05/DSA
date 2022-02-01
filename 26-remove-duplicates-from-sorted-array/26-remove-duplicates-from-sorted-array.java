class Solution {
    public int removeDuplicates(int[] nums) {
        int ind=0;
        int i=0;
        for(i=0;i<nums.length;){
            while(ind<nums.length && nums[i]==nums[ind])ind++;
            if(i<nums.length-1 && ind<nums.length){
        
            nums[i+1]=nums[ind];
            }
            i++;ind++;
            if(ind>nums.length )break;
        }
        return i;
    }
}