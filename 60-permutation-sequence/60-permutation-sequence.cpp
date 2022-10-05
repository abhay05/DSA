class Solution {
public:
    int dp[10];
    string getPermutation(int n, int k) {
        dp[0]=1;
        for(int i=1;i<=9;i++){
            dp[i]=i*dp[i-1];
        }
        string ans="";
        set<char>st;
        
        for(int i=1;i<=n;i++){
            st.insert(i+'0');
        }
        auto it=st.begin();
        for(int i=n;i>=1;i--){
            int rem=(k+dp[i-1]-1)/dp[i-1];
            k=(k-(rem-1)*(dp[i-1]));
            int times=rem-1;
            //times--;
            auto it1=st.begin();
            while(times>0){
                it1++;
                times--;
            }
            char c=*it1;
            ans=ans+*it1;
            //cout<<i<<' '<<c<<'\n';
            if(!st.empty()){
            //    cout<<i<<' '<<c<<'\n';
            st.erase(st.find(c));}
        }
        return ans;
    }
};