class Solution {
    public int removeElement(int[] nums, int val) {
        int first=0;
        int second=0;
        int n=nums.length;
        int cnt=0;
        while(first<n){
            if(nums[first]==val){cnt++;}
            else{
                nums[second]=nums[first];
                second++;
            }
            first++;
        }
        return n-cnt;
    }
}