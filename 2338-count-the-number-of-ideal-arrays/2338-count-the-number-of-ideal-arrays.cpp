class Solution {
public:
    int MOD=1000000007;
    map<pair<int,int>,int>mp;
    int c[10001][14];
    void init(){
        for(int i=0;i<10001;i++){
            c[i][0]=1;
        }
        for(int i=1;i<10001;i++){
            for(int j=1;j<14;j++){
                if(j>i){c[i][j]=0;continue;}
                if(i==j){c[i][j]=1;continue;}
                c[i][j]=(c[i-1][j-1]+c[i-1][j])%MOD;
            }
        }
    }
    int recur(int ind,int val,int n,int maxValue){
        if(val>maxValue)return 0;
        if(ind==n-1){
            return 1;
        }
        if(mp.find({ind,val})!=mp.end())return mp[{ind,val}];
        int ans=c[n-1][ind];
       // cout<<ind<<' '<<val<<' '<<n<<' '<<maxValue<<'\n';
        for(int i=2;i*val<=maxValue;i++){
            ans=(ans+recur(ind+1,i*val,n,maxValue))%MOD;
        }
        mp[{ind,val}]=ans;
        return ans;
    }
    
    int idealArrays(int n, int maxValue) {
        init();
        int ans=0;
        for(int i=1;i<=maxValue;i++){
            ans=(ans+recur(0,i,n,maxValue))%MOD;
        }
        return ans;
    }
};