class Solution {
    public int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int[] max1=new int[j+1];
        int[] max2=new int[j+1];
        for(int ind=0;ind<=j;ind++){
            max1[ind]=Math.max(height[ind],(ind>0?max1[ind-1]:0));
        }
        for(int ind=j;ind>=0;ind--){
            max2[ind]=Math.max(height[ind],(ind<j?max2[ind+1]:0));
        }
        int ans=0;
        for(int ind=0;ind<=j;ind++){
            int val=(Math.min((ind>0?max1[ind-1]:0),(ind<j?max2[ind+1]:0))-height[ind]);
            ans+=(val<0?0:val);
        }
        return ans;
    }
}