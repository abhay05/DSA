class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    
    int[][] dp= new int[10001][101];
    
    
    public int superEggDrop(int k, int n) {
        if(k==1)return n;
        int cnt=0;
        int temp=n;
        
        while(temp!=0){
            temp=(temp>>1);
            cnt++;
        }
        
        
        if(k>=cnt)return cnt;
        for(int i=0;i<51;i++){
            for(int j=0;j<101;j++){
                dp[i][j]=-1;
            }         
         }
        dp[0][0]=0;
        for(int i=0;i<101;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<51;i++){
      //      dp[i][1]=1;
            dp[i][0]=0;
        }
       // dp[0][0]=-1;
        int m=1;
        int val=0;
        int eggs=2;
        while(val<n){
            eggs=1;
            while(eggs<=k){
            dp[m][eggs]=dp[m-1][eggs]+1+dp[m-1][eggs-1];
                eggs++;
            }
            val=dp[m][k];
            m++;
            
        }
        return --m;
    }
}