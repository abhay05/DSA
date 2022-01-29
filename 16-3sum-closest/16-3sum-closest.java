class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum=1000000000;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int a=target-(nums[i]+nums[j]);
                int l=j+1;
                int u=nums.length-1;
                while(l<=u){
                    int mid=(l+u)/2;
                    
                     // System.out.println(minSum);
                     // System.out.println(ans);
                    // System.out.println(u);
                    // System.out.println(a);
                    if(nums[mid]<a){
                        l=mid+1;
                        if(minSum>a-nums[mid]){
                          minSum=Math.min(minSum,a-nums[mid]);
                            ans=nums[i]+nums[j]+nums[mid];
                        }
                        if(mid+1<nums.length && Math.abs(nums[mid+1]-a)<Math.abs(nums[mid]-a)){
                            
                            if(minSum>Math.abs(nums[mid+1]-a)){
                          minSum=Math.min(minSum,Math.abs(nums[mid+1]-a));
                                ans=nums[i]+nums[j]+nums[mid+1];
                        }
                        }
                    }else if(nums[mid]>a){
                        
                        if(minSum>nums[mid]-a){
                          minSum=Math.min(minSum,nums[mid]-a);
                            ans=nums[i]+nums[j]+nums[mid];
                        }
                        if(mid-1>=l && Math.abs(nums[mid-1]-a)<Math.abs(nums[mid]-a)){
                            
                                if(minSum>Math.abs(nums[mid-1]-a)){
                          minSum=Math.min(minSum,Math.abs(nums[mid-1]-a));
                                ans=nums[i]+nums[j]+nums[mid-1];
                        }
                            
                        }
                        // System.out.println("Bigger");
                        // System.out.println(ans);
                        // System.out.println(minSum);
                        u=mid-1;
                    }else{
                        return target;
                    }
                }
            }
        }
        return ans;
    }
}