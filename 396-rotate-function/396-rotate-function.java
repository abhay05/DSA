class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int cumsum=0;
        int cumsum1=0;
        int[] arr=new int[nums.length];
        for(int i=0;i<n;i++){
            cumsum+=(i-1<0?n-1:i-1)*nums[i];
            cumsum1+=nums[i];
        }
        for(int i=0;i<n;i++){
            arr[i]=cumsum1-nums[i];
        }
        int last=cumsum;
        int maxi=cumsum;
        for(int i=1;i<n;i++){
            last=last+(n-1)*nums[i]-arr[i];
            maxi=Math.max(last,maxi);
        }
        return maxi;
    }
}