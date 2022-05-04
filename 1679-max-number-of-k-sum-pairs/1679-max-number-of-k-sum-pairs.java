class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer>mp=new HashMap<Integer,Integer>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],1);
            }else{
                mp.put(nums[i],mp.get(nums[i])+1);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(mp.get(nums[i])>0){
                int val=k-nums[i];
                mp.put(nums[i],mp.get(nums[i])-1);
                if(mp.get(val)!=null && mp.get(val)>0){
                    ans++;
                    mp.put(val,mp.get(val)-1);
                }else{
                    mp.put(nums[i],mp.get(nums[i])+1);
                }
            }
        }
        return ans;
    }
}