class Solution {
    
    public int sumOfFlooredPairs(int[] nums) {
        int mod=1000000007;
        int n=nums.length;
        Arrays.sort(nums);
        int[] sieve = new int[100001];
        for(int i=0;i<100001;i++){
            sieve[i]=0;
        }
        HashMap<Integer,Integer> mp= new HashMap<Integer,Integer>();
        int maxVal=0;
        for(int i=0;i<n;i++){
            int val=0;
        if(mp.containsKey(nums[i])){val=mp.get(nums[i]);}
         mp.put(nums[i],val+1);   
        maxVal=Math.max(maxVal,nums[i]);
        }
        
        for(int i=1;i<=maxVal;i++){
            if(mp.containsKey(i)){
            for(int times=1;times*i<=maxVal;times++){
                sieve[times*i]+=mp.get(i);
            }
            }
        }
        for(int i=2;i<=maxVal;i++){
            sieve[i]=(sieve[i]+sieve[i-1])%mod;
        }
        long ans=0;
        for(int i=1;i<=maxVal;i++){
            if(mp.containsKey(i)){
                ans=(ans+((long)sieve[i]*mp.get(i))%mod)%mod;
            }
        }
        return (int)ans;
    }
}