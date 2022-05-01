class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int u=nums.length-1;
        while(l<u){
            int m=(l+u)/2;
           // System.out.println(l+" "+m+" "+u);
            if(nums[m]<target){
                l=m+1;
            }else{
                u=m;
            }
        }
        if(nums[l]<target)return l+1;
        return l;
    }
}