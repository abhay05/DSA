class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j=0;
        int n=nums.length;
        for(int i=1;i<n && j<n;){
            
            if(nums[i]%2==0){
                if(nums[j]%2==0){
                    j++;
                    while(j>=i){i++;}
                    
                }else{
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    j++;
                    i++;
                }
            }else{
                i++;
            }
        }
        return nums;
    }
}