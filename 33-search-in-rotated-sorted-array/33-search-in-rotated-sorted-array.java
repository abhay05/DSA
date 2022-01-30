class Solution {
    
    public int binSearch(int[] nums,int l,int u,int target){
        while(l<=u){
            int mid=(l+u)/2;
            if(target<nums[mid]){
                    u=mid-1;
            }else if(target>nums[mid]){
                    l=mid+1;
            }else{
                return mid;
            }
            
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int n=nums.length;
        int curr=0;
        while(true){
            
            if((curr+1<n && nums[curr+1]<nums[curr]) || curr+1>=n)break;
            for(int i=1;;i*=2){
                if((curr+i<n && nums[curr+i]<nums[curr]) || curr+i>=n) {
                    curr+=i/2;
                    break;
                }
            }
        }

        return Math.max(binSearch(nums,0,curr,target),binSearch(nums,curr+1,n-1,target));
    }
}