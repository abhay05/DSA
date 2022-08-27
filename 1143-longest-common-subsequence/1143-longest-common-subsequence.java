class Solution {
    int dp[][]=new int[1001][1001];
    int recur(String s, int st1,int end1, String t,int st2, int end2){
        
        if(st1>end1)return 0;
        if(st2>end2)return 0;
        if(dp[st1][st2]!=-1)return dp[st1][st2];
        int ans=0;
        if(s.charAt(st1)==t.charAt(st2)){
            ans=recur(s,st1+1,end1,t,st2+1,end2)+1;
        }else{
            ans=Math.max(recur(s,st1,end1,t,st2+1,end2),recur(s,st1+1,end1,t,st2,end2));
        }
        dp[st1][st2]=ans;
        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        String s=text1;
        String t=text2;
        int n=s.length();
        int m=t.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return recur(s,0,n-1,t,0,m-1);
    }
}