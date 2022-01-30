class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int st=0;
        int ind=-1;
        int maxValue=nums[n-1];
        for(int i=n-2;i>=0;i--){
            int val=nums[i];
            if(nums[i]<nums[i+1]){st=i;break;}   
        }
        int minVal=1000000000;
        int j=st+1;
        while(j<n){
            if(nums[j]>nums[st] && minVal>=nums[j]){
                minVal=nums[j];
                ind=j;
            }
            j++;
        }
        if(ind!=-1){
                int temp=nums[st];
                nums[st]=nums[ind];
                nums[ind]=temp;
                st=st+1;
            }
              int i=st;
             j=n-1;
            while(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
            
        
    }
}