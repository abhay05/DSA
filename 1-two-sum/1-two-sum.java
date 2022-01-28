class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans={};
      
        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            h2.put(nums[i],i);
        }
        List<Integer> temp=new ArrayList<Integer>();
        if(target%2==0){
      //  if(1){
            int val=target/2;
            
            for(int i=0;i<nums.length;i++){
                
                if(nums[i]==val){
                    temp.add(i);
                    if(temp.size()==2){
                        System.out.println(1);
                        ans=new int[]{temp.get(0),temp.get(1)};
                        break;}
                }
            }
            
          //  ans=temp;
        //}
        }
        if(temp.size()<2){
        
        for(int i=0;i<nums.length;i++){
            int tt=target-nums[i];
            if(h2.containsKey(tt) && tt!=target/2){
               
                ans=new int[]{i,h2.get(tt)};
                break;
            }
        }
            
        }
        return ans;
    }
}