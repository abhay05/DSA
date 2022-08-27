class Solution {
    int dp[][]=new int[1001][1001];
    int recur(String s,int st,int end){
        if(end==st)return 1;
        if(st+1==end){
            if(s.charAt(st)==s.charAt(end))return 2;
            return 1;
        }
        if(dp[st][end]!=-1)return dp[st][end];
        int ans=0;
        if(s.charAt(st)==s.charAt(end)){
            ans=Math.max(ans,recur(s,st+1,end-1)+2);
        }
        else{
            ans=Math.max(ans,recur(s,st+1,end));
            ans=Math.max(ans,recur(s,st,end-1));
        }
        dp[st][end]=ans;
        return ans;
    }
    
    public int longestPalindromeSubseq(String s) {
    //    for(int i=0;i<)
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return recur(s,0,n-1);
    }
}