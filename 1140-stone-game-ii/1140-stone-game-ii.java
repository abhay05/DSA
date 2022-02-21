class Solution {
    
    int[][][] dp= new int[101][100][2];
    
    int recur(int[] cumsum,int ind,int m,int flag){
        if(ind>=cumsum.length){
            return 0;
        }
        if(dp[ind][m][flag]!=-1){
            return dp[ind][m][flag];
        }
        int maxi=0;
        int retVal=0;
        if(flag==1){
        for(int i=ind+1;i<=ind+2*m && i<cumsum.length;i++){
          //  System.out.println("file size "+ind+" "+i+" "+m+" "+flag+" "+(cumsum[i]-cumsum[ind]));
            int val=recur(cumsum,i,Math.max(i-ind,m),0);
         //   System.out.println("val "+val);
            maxi=Math.max(maxi,val+cumsum[i]-cumsum[ind]);
            if(val+cumsum[i]-cumsum[ind]>maxi){
                maxi=val+cumsum[i]-cumsum[ind];
                retVal=val;
            }
          //  System.out.println(cumsum[i]-cumsum[ind]);
        }
        }else{
            for(int i=ind+1;i<=ind+2*m && i<cumsum.length;i++){
              //  System.out.println(cumsum[i]-cumsum[ind]);
                int val=recur(cumsum,i,Math.max(i-ind,m),1);
                if(val+cumsum[i]-cumsum[ind]>maxi){
                    maxi=val+cumsum[i]-cumsum[ind];
                    
                }
           
            
        }
        }
        dp[ind][m][flag]=cumsum[cumsum.length-1]-cumsum[ind]-maxi;
        return cumsum[cumsum.length-1]-cumsum[ind]-maxi;
    }
    
    public int stoneGameII(int[] piles) {
        int[] cumsum=new int[piles.length+1];
        cumsum[0]=0;//piles[0];
        for(int i=1;i<=piles.length;i++){
            cumsum[i]=cumsum[i-1]+piles[i-1];
        }
        for(int i=0;i<101;i++){
            for(int j=0;j<100;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int maxi=recur(cumsum,0,1,1);
        return cumsum[piles.length]-maxi;
    }
}