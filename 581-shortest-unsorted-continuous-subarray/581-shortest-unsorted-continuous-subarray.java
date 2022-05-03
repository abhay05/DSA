class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=nums[i];
        }
        Arrays.sort(temp);
        int l=0;
        int u=n-1;
        while(l<n && temp[l]==nums[l]){
            l++;
        }
        while(u>=0 && temp[u]==nums[u]){
            u--;
        }
        return l<=u?u-l+1:0;
    }
}