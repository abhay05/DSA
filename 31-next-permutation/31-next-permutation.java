class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int st=0;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            int val=nums[i];
            int minMax=1000000000;
            
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i] && minMax>nums[j]){
                    minMax=nums[j];
                    ind=j;
                }
            }
            if(ind!=-1){
                st=i;
                break;
            }
            cnt++;
        }
        if(cnt==n-1){
              int i=0;
            int j=n-1;
            while(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
            
        }else{
        int temp=nums[ind];
//         while(ind>st){
                
//                 nums[ind]=nums[ind-1];
               
//                 ind--;
//             }
            nums[ind]=nums[st];
        nums[st]=temp;
            Arrays.sort(nums,st+1,n);
        }
    }
}