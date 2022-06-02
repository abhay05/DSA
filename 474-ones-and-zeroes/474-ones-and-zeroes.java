class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[101][101];
        dp[0][0]=0;
        List<Pair<Integer,Integer>>list=new ArrayList<Pair<Integer,Integer>>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            int cnt0=0;
            int cnt1=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='0'){
                    cnt0++;
                }else{
                    cnt1++;
                }
            }
            list.add(new Pair(cnt0,cnt1));
        }
        int[][] ind=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                ind[i][j]=-1;
            }
        }
        int ans=0;
        for(int k=0;k<list.size();k++){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                
                    Pair<Integer,Integer>p=list.get(k);
                    if(i+p.getKey()<=m && j+p.getValue()<=n && ind[i+p.getKey()][j+p.getValue()]<k){
                        if(dp[i][j]<dp[i+p.getKey()][j+p.getValue()]+1){
                            dp[i][j]=dp[i+p.getKey()][j+p.getValue()]+1;
                            ind[i][j]=k;
                            //System.out.println(i+" "+j+" "+dp[i][j]+" "+k);
                            ans=Math.max(ans,dp[i][j]);
                        }
                    }
                }
            }
        }
       // int ans=0;
        return ans;
        
    }
}