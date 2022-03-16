class Solution {
   static HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int findWinner(int n,int p){
        if(n==0){
            return 1-p;
        }
        if(mp.containsKey(n*2+p))return mp.get(n*2+p);
        for(int i=1;i*i<=n;i++){
            if((1-(p^findWinner(n-i*i,1-p)))>=1){
                mp.put(n*2+p,p);
                return p;
            }
        }
        mp.put(n*2+p,1-p);
        return 1-p;
    }
    
    public boolean winnerSquareGame(int n) {
        return findWinner(n,1)==1;
    }
}