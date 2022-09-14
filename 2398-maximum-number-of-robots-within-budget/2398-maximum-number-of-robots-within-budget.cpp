class Solution {
public:
    
    int tree[4*100005];
    
    void init(){
        for(int i=0;i<4*100005;i++){
            tree[i]=0;
        }    
    }
    
    void build(int node,int l,int r, vector<int>& dp){
        if(r==l){
            tree[node]=dp[l-1];
            return ;
        }
        
        int m=(r+l)/2;
        build(2*node,l,m,dp);
        build(2*node+1,m+1,r,dp);
        tree[node]=max(tree[2*node],tree[2*node+1]);
        return ;
    }
    
    
    int get(int node,int l,int r,int st,int end){
        if(st>r || end<l){
            return -1;
        }
        
        if(st==l && r==end){
            return tree[node];
        }
        
        int m=(l+r)/2;
        //cout<<node<<" "<<l<<" "<<r<<" "<<st<<" "<<end<<"\n";
       // if(m>st && m<end){
        int val1=get(2*node,l,m, st,min(end,m));
        int val2=get(2*node+1,m+1,r,max(m+1,st),end);
            return max(val1,val2); 
       
        
    }
    
    long long getCost(vector<long long>& runningCosts, int left,int right,int n){
        if(left>right)return 1000000000;
        int maxval=(long long)get(1,1,n,left+1,right+1);
       // cout<<"hell "<<left<<' '<<right<<" "<<maxval<<"\n";
        return maxval+(runningCosts[right]-(left==0?0:runningCosts[left-1]))*(right-left+1);
    }
    
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCostsT, long long budget) {
        int n=chargeTimes.size();
        init();
        build(1,1,n,chargeTimes);
        vector<long long>runningCosts;
        for(int i=0;i<n;i++){
            runningCosts.push_back((long long)runningCostsT[i]);    
        }
        for(int i=1;i<n;i++){
            runningCosts[i]+=runningCosts[i-1];
        }
        int left=0;
        int right=0;
        int ans=0;
        while(right<n && left<n){
            while(left>right){right++;}
            if(right>n)break;
            long long cost=getCost(runningCosts,left,right,n);
           // cout<<cost<<" "<<left<<" "<<right<<"\n";
            if(cost>budget){
                left++;
            }
            else if(cost<=budget){
                ans=max(ans,(right-left+1));
                right++;
            }
            
        }
        return ans;
    }
};