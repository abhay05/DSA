class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>hs=new HashSet<String>();
        for(String e:wordDict){
            hs.add(e);
        }
        int n=s.length();
        boolean dp[]=new boolean[n];
        if(hs.contains(String.valueOf(s.charAt(0)))){
            dp[0]=true;
        }
        for(int i=1;i<n;i++){
            if(hs.contains(s.substring(0,i+1))){
                dp[i]=true;
            }
            for(int j=0;j<i;j++){
                if(dp[j]==true){
                    if(hs.contains(s.substring(j+1,i+1))){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }

        return dp[n-1];
    }
}