class Solution {
   static HashMap<Integer,Integer>hm = new HashMap<Integer,Integer>();
    
    int getMini(int val){
        if(val==0){
            return 0;
        }
        if(hm.containsKey(val)){return hm.get(val);}
        int mini=1000000000;

        for(int i=1;i*i<=val;i++){            
            int cnt=1;  
            int sq=i*i;
            int temp=val-sq; 
                mini=Math.min(mini,getMini(temp)+cnt);
                cnt++;
        }

        hm.put(val,mini);
        return mini;
    }
    
    public int numSquares(int n) {
        if(hm.containsKey(n))return hm.get(n);
        return getMini(n);
    }
}