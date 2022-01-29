class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int st=0;
        int ind=-1;
        int maxValue=nums[n-1];
        for(int i=n-2;i>=0;i--){
            int val=nums[i];
            int minMax=1000000000;
            
            if(maxValue<val){maxValue=val;continue;}
            Arrays.sort(nums,i+1,n);
            int l=i+1;
            int u=n-1;
            while(l<=u){
                int mid=(l+u)/2;
                if(nums[mid]>nums[i]){
                    u=mid-1;
                    
                    if(nums[mid-1]<=nums[i]){
                        ind=mid;break;
                    }
                }else if(nums[mid]<=nums[i]){
                    l=mid+1;
                }
            }
            if(ind!=-1){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
                break;
            }
            
        }
        if(ind==-1){
  System.out.println("hh");
              int i=0;
            int j=n-1;
            while(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
            }
            
        }
    }
}