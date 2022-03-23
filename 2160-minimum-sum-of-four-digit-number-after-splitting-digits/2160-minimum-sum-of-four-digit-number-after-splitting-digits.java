class Solution {
    public int minimumSum(int num) {
        char[] nums=(""+num).toCharArray();
        Arrays.sort(nums);
        int a=(nums[0]-'0')*10+(nums[3]-'0');
        int b=(nums[1]-'0')*10+(nums[2]-'0');
        return (a+b);
    }
}