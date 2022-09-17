class Solution {
public:
    int numDistinct(string s, string t) {
        unsigned long long dp[t.size()+1];
        for(int i=0;i<t.size();i++)dp[i]=(unsigned long long)0;
        dp[t.size()]=(unsigned long long)1;
        for(int i=s.size()-1;i>=0;i--){
            for(int j=0;j<t.size();j++){
                dp[j]=dp[j]+(s[i]==t[j]?dp[j+1]:0LL);
            }
        }
        return dp[0];
    }
};