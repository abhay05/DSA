class Solution {
     
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        int[][] store=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                store[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
            store[i][i]=1;
            ans++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                store[i][i+1]=1;
                ans++;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                if(s.charAt(i)==s.charAt(i+len-1)){
                    store[i][i+len-1]=store[i+1][i+len-1-1];
                }else{
                    store[i][i+len-1]=0;
                }
                if(store[i][i+len-1]==1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}