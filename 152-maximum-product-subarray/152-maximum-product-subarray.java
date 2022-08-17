class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int mulmax=nums[0];
        int mulmin=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
           //System.out.println(ans+" "+mulmin+" "+mulmax); 
            int mulmax1=Math.max(nums[i],Math.max(nums[i]*mulmax,nums[i]*mulmin));
            int mulmin1=Math.min(nums[i],Math.min(nums[i]*mulmax,nums[i]*mulmin));
            mulmax=mulmax1;
            mulmin=mulmin1;
            ans=Math.max(ans,mulmax);
            
        }
      //  System.out.println(ans+" "+mulmin+" "+mulmax);
        return ans;
    }
}