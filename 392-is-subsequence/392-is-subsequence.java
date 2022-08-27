class Solution {
    int dp[]=new int[10001];
    boolean recur(String s, int st1,int end1, String t,int st2, int end2){
        
        if(st1>end1)return true;
        if(st2>end2)return false;
        if(dp[st2]!=-1)return dp[st2]==1?true:false;
        boolean ans=false;
        if(s.charAt(st1)==t.charAt(st2)){
            ans=(ans|recur(s,st1+1,end1,t,st2+1,end2));
        }else{
            ans=(ans|recur(s,st1,end1,t,st2+1,end2));
        }
        dp[st2]=(ans==true?1:0);
        return ans;
    }
    
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        for(int i=0;i<m;i++){
            dp[i]=-1;
        }
        return recur(s,0,n-1,t,0,m-1);
    }
}