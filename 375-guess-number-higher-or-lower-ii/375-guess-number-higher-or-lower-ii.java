class Solution {
    HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int recur(int st,int end){
        if(st>=end){
            return 0;
        }
        if(mp.containsKey(st*200+end))return mp.get(st*200+end);
        int ans=1000000000;
        for(int i=st;i<=end;i++){
           ans=Math.min(ans, i+Math.max(recur(st,i-1),recur(i+1,end)));    
        }
        mp.put(st*200+end,ans);
        return ans;
    }
    
    public int getMoneyAmount(int n) {
        int money=recur(1,n);
        return money;
    }
}