class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum=1000000000;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            int val=target-nums[i];
            while(j<k){
                
                if(val-(nums[j]+nums[k])>0){
                    if(minSum>Math.abs(val-(nums[j]+nums[k]))){
                    minSum=Math.abs(val-(nums[j]+nums[k]));
                    ans=nums[i]+nums[j]+nums[k];
                }
                    j++;
                }else if(val-(nums[j]+nums[k])<0){
                    if(minSum>Math.abs(val-(nums[j]+nums[k]))){
                    minSum=Math.abs(val-(nums[j]+nums[k]));
                    ans=nums[i]+nums[j]+nums[k];
                }
                    k--;
                }else{
                    return nums[i]+nums[j]+nums[k];
                }
                
                
            }
        }
        return ans;
    }
}