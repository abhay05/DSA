KN^2 solution

```
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
    
    public int getEggs(int n,int i,int eggs){
        if(i==n){
            return 0;
        }
        if(eggs==1){
            return 0;
        }
        if(dp[n-i][eggs]!=-1){return dp[n-i][eggs];}
        int maxi=1000000000;
        for(int j=i+1;j<=n;j++){
           maxi=Math.min(maxi,Math.max(getEggs(n,j,eggs)+1,getEggs(n,n-(j-i)+1,eggs-1)+(eggs-1==1?j-i:1)));
            
        }
        dp[n-i][eggs]=maxi;
        return maxi;
    }
    
    public int superEggDrop(int k, int n) {
        if(k==1)return n;
        for(int i=0;i<10001;i++){
            for(int j=0;j<101;j++){
                dp[i][j]=-1;
            }         
         } 
        return getEggs(n,0,k);
    }
}
```

KNlogN solution

```
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
    
    public int getEggs(int n,int i,int eggs){
        if(i==n){
            return 0;
        }
        if(eggs==1){
            return 0;
        }
        if(dp[n-i][eggs]!=-1){return dp[n-i][eggs];}
        int maxi=1000000000;
        
        int l=i+1;
        int u=n;
        int best=-1;
        while(l+1<u){  
            int mid=(l+u)/2;
          //  System.out.println(l+" "+mid+" "+u);
            int val1=getEggs(n,mid,eggs)+1;
            int val2=getEggs(n,n-(mid-i)+1,eggs-1)+(eggs-1==1?mid-i:1);
            
            if(val1>val2){
                l=mid;
            }else if(val2>val1){
                u=mid;
            }else{
             best=mid;
                break;
            }
        }
        if(best!=-1){
            maxi=Math.min(maxi,Math.max(getEggs(n,best,eggs)+1,getEggs(n,n-(best-i)+1,eggs-1)+(eggs-1==1?best-i:1)));
        }
        else{
            maxi=Math.min(maxi,Math.max(getEggs(n,l,eggs)+1,getEggs(n,n-(l-i)+1,eggs-1)+(eggs-1==1?l-i:1)));
            maxi=Math.min(maxi,Math.max(getEggs(n,u,eggs)+1,getEggs(n,n-(u-i)+1,eggs-1)+(eggs-1==1?u-i:1)));
        }
        
        dp[n-i][eggs]=maxi;
        return maxi;
    }
    
    public int superEggDrop(int k, int n) {
        if(k==1)return n;
        for(int i=0;i<10001;i++){
            for(int j=0;j<101;j++){
                dp[i][j]=-1;
            }         
         } 
        return getEggs(n,0,k);
    }
}
```

