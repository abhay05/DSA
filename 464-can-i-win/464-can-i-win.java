class Solution {
    HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int willIWin(int bit,int maxChoosableInteger,int desiredTotal,int person){
       if(bit==(1<<maxChoosableInteger)-1){return 0;}
        int winner=0;
      //  System.out.println(bit+" "+person+" "+desiredTotal);
        if(mp.containsKey(bit)){
            return mp.get(bit);
        }
        for(int i=0;i<maxChoosableInteger;i++){
            if((bit&(1<<i))==0){
                if(desiredTotal-(i+1)<=0){
                    mp.put(bit,person);
                  return person;
                   
                }else{
                int z=willIWin((bit^(1<<i)),maxChoosableInteger,desiredTotal-(i+1),1-person);
                if(z==person){
                    mp.put(bit,person);
                   return person; 
                }
                
                }
            }
        }
        mp.put(bit,1-person);
        return 1-person;
    }
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        int sum=maxChoosableInteger*(maxChoosableInteger+1);
        sum/=2;
        if(sum<desiredTotal)return false;
        int i=willIWin(0,maxChoosableInteger,desiredTotal,1);
        if(i==1)return true;
        return false;
    }
}