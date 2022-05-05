class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer>mp=new HashMap<Integer,Integer>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int val=k-nums[i];
            if(!mp.containsKey(val) || mp.get(val)==0){
                if(mp.containsKey(nums[i])){
                    mp.put(nums[i],mp.get(nums[i])+1);
                }else{
                    mp.put(nums[i],1);
                }
                
            }else{
                
                    ans++;
                mp.put(val,mp.get(val)-1);
                
            }
        }
        return ans;
    }
}