class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==i){continue;}
            while(nums[i]!=i+1){
                int val=nums[i];
                int val1=nums[val-1];
                if(val==val1)return val;
                nums[i]=val1;
                nums[val-1]=val;

        }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return -1;
    }
}