class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[101][101];
        dp[0][0]=0;
        for(int k=0;k<strs.length;k++){
            String s=strs[k];
            int cnt0=0;
            int cnt1=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='0'){
                    cnt0++;
                }else{
                    cnt1++;
                }
            }
        for(int i=0;i<=m-cnt0;i++){
            for(int j=0;j<=n-cnt1;j++){
                if(dp[i][j]<dp[i+cnt0][j+cnt1]+1){
                            dp[i][j]=dp[i+cnt0][j+cnt1]+1;
                        }
                    }
            }
        }

        return dp[0][0];
        
    }
}