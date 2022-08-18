class Solution {
    public int getMaxLen(int[] nums) {
        
        
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            nums[i]=(nums[i]>0?1:(nums[i]<0?-1:0));
        }
        
        int lenmax=0;
        int lenmin=0;
        int len=0;
        int mulmax=1;
        int mulmin=1;
        int mul=1;
        
        if(nums[0]>0){
            lenmax=1;
            mulmax=nums[0];
            len=1;
        }
        if(nums[0]<0){
            lenmin=1;
            mulmin=nums[0];
        }
        
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=mulmax;
                mulmax=mulmin;
                mulmin=temp;
                
                temp=lenmax;
                lenmax=lenmin;
                lenmin=temp;
            }
            
            if(mulmax*nums[i]>0){
                lenmax=lenmax+1;
                mulmax=mulmax*nums[i];
            }
            else{
                if(nums[i]>0){
                lenmax=1;
                mulmax=nums[i];}else{
                    lenmax=0;
                    mulmax=1;
                }
            }
            
            if(mulmin*nums[i]<0){
                lenmin=lenmin+1;
                mulmin=mulmin*nums[i];
            }
            else{
                if(nums[i]<0){
                lenmin=1;
                mulmin=nums[i];}else{
                    lenmin=0;
                mulmin=1;
                }
            }
            len=Math.max(len,lenmax);
        }
        return len;
    }
}