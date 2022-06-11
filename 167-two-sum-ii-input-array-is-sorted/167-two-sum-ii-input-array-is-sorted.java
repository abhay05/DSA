class Solution {
    public int[] twoSum(int[] numbers, int target) {
      //  numbers[0]=-1001;
        int n=numbers.length;
        for(int i=0;i<n;i++){
            int x=target-numbers[i];
            int ansind=Arrays.binarySearch(numbers,x);
            if(ansind>i){
                return new int[]{i+1,ansind+1};
            }
            else if(ansind==i){
                if(numbers[i]==numbers[i+1]){
                    return new int[]{i+1,i+2};
                }
            }
        }
        return new int[]{};
    }
}