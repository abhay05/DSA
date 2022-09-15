class Solution {
public:
    
    int dp[1001][4001];
    int N=1000000007;
    
    int recur(int k, int pos, int K, int endPos){
        if(k>=K){
            if(pos==endPos)return 1;
            return 0;
        }
        if(pos>4000 || pos<0)return 0;
        if(dp[k][pos]!=-1)return dp[k][pos]-1;
        int ans=(1+recur(k+1,pos+1,K,endPos)%N+recur(k+1,pos-1,K,endPos)%N)%N;
        dp[k][pos]=ans;
        return ans-1;
    }
    
    int numberOfWays(int startPos, int endPos, int k) {
        for(int i=0;i<1001;i++){
            for(int j=0;j<4001;j++){
                dp[i][j]=-1;
            }
        }
        return recur(0,startPos+2000,k,endPos+2000);
        
    }
};