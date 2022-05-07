class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        Stack<Integer>st=new Stack<Integer>();
        st.push(nums[n-1]);
        int s2=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            if(s2>nums[i]){
                return true;
            }else{
                while(st.size()>0 && st.peek()<nums[i]){
                    s2=st.peek();
                    st.pop();
                }
            }
            st.push(nums[i]);
        }
        return false;
        
    }
}