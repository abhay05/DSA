class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<List<Integer>>();
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){
            int temp=i;
           List<Integer>slist=new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                 if((i&(1<<j))>0){
                    slist.add(nums[j]);
                }
            }
            list.add(slist);
        }
        return list;
    }
}