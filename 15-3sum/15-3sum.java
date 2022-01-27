class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>answer=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     System.out.println(nums[i]);
        // }
        
        for(int i=0;i<nums.length;i++){
            
            int j=i+1;
            int k=nums.length-1;
            
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer>temp=new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        answer.add(temp);
                    
                    j++;
                    while(j<nums.length && nums[j]==nums[j-1]){
                        j++;
                        
                    }
                    if(j>=nums.length)break;
                    k=nums.length-1;
                   // break;
                    }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    j++;
                }
            }
            
        }
        
        return answer;
    }
}