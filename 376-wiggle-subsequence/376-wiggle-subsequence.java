class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        arr[0][0]=1;
        arr[0][1]=1;
        int ans=Math.max(arr[0][1],arr[0][0]);
        for(int i=1;i<n;i++){
            arr[i][0]=1;
            arr[i][1]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    arr[i][0]=Math.max(arr[i][0],arr[j][1]+1);
                    
                }else if(nums[i]<nums[j]){
                    arr[i][1]=Math.max(arr[i][1],arr[j][0]+1);
                }
                ans=Math.max(ans,Math.max(arr[i][0],arr[i][1]));
            }
            
        }
        return ans;
    }
}