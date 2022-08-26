class Solution {
    public int trap(int[] height) {
        int leftind=0;
        int rightind=height.length-1;
        int left=height[leftind];
        int right=height[rightind];
        int ans=0;
        int currind=0;
        while(leftind<=rightind){
            if(height[leftind]>left){
                left=height[leftind];
            }
            if(height[rightind]>right){
                right=height[rightind];
            }
            ans+=Math.max(Math.min(left,right)-height[currind],0);
            
        if(left<=right){
            leftind++;
            currind=leftind;
        }else{
            rightind--;
            currind=rightind;
        }
        }
        return ans;
    }
}