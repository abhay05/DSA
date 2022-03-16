class Solution {
   static HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int findWinner(int n){
        
        if(n==0){
            return 0;
        }
        if(mp.containsKey(n))return mp.get(n);
        for(int i=1;i*i<=n;i++){
            if(n-i*i==0){
                mp.put(n,1);
                return 1;
            }
            if(findWinner(n-i*i)==0){
                mp.put(n,1);
                return 1; 
            }
            
        }
        mp.put(n,0);
        return 0;
    }
    
    public boolean winnerSquareGame(int n) {
        return findWinner(n)==1;
    }
}