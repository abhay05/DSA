class Solution {
public:
    int MOD=1000000007;
    int di[4]={0,1,0,-1};
    int dj[4]={1,0,-1,0};
    vector<vector<int>>vis;
    vector<vector<int>>dp;
    int recur(vector<vector<int>>&grid,int i,int j, int cnt,int n,int m,int pari,int parj){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        vis[i][j]=cnt;
        int ans=1;
        for(int k=0;k<4;k++){
             int ni=i+di[k];
             int nj=j+dj[k];
            
            if(nj>=0 && nj<n && ni>=0 && ni<m){
            if(grid[i][j]<grid[ni][nj]){
                if(ni!=pari || nj !=parj){
                    ans=(ans+recur(grid,ni,nj,cnt,n,m,i,j))%MOD;}
                }
             }
        }
        dp[i][j]=ans;
        return ans;
    }
    
    int countPaths(vector<vector<int>>& grid) {
        int m=grid.size();
        int n=grid[0].size();
        for(int i=0;i<m;i++){
            vector<int>temp;
            for(int j=0;j<n;j++){
                temp.push_back(-1);
            }
            vis.push_back(temp);
        }
        
        int anss=0;
        int cnt=1;
        for(int i=0;i<m;i++){
            vector<int>temp;
            for(int j=0;j<n;j++){
                temp.push_back(-1);
            }
            dp.push_back(temp);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    int temp=recur(grid,i,j,cnt,n,m,-1,-1);
                //cout<<i<<' '<<j<<' '<<temp<<'\n';
                    anss=(anss+(temp==-1?0:temp))%MOD;
                    cnt++;
                
            }
        }
        
        return anss;
    }
};