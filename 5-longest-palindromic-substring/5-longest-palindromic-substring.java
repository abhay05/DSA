class Solution {
    
    int[][] dp=new int[1001][1001];
    
    public void recur(String s,int st,int end,int val){
        
        if(st==end || st+1==end){
             if(s.charAt(st)==s.charAt(end)){
               // return val+2;
                 dp[st][end]=1;
            }
            return ;
        }
        
        if(dp[st][end]==1)return;
        
        int ans=0;
        if(s.charAt(st)==s.charAt(end)){
            recur(s,st+1,end-1,val+2);
            if(dp[st+1][end-1]==1){
                dp[st][end]=1;
            }
        }
            recur(s,st+1,end,0);
            recur(s,st,end-1,0);
        
      //  dp[st][end]=ans;
        return ;
    }
    
    public String longestPalindrome(String s) {
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                dp[i][j]=-1;
            }
        }
        int ansInd=0;
        int ans=1;
        for(int i=0;i<=1000;i++){
            dp[i][i]=1;
            if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                
                    ans=2;
                    ansInd=i;
                
            }
            
        }
        
        for(int len=3;len<=s.length();len++){
            for(int i=0;i<s.length()-len+1;i++){
                int j=i+len-1;
                if(dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=1;
                    if(len>ans){
                    ans=len;
                    ansInd=i;
                }
                }
            }
        }
        
      
        return s.substring(ansInd,ansInd+ans);
    }
}