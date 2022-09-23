class Solution {
public:
    
    int size[100001];
    int par[100001];
    
    void unionT(int u,int v){
        if(size[u]>size[v]){
            size[u]+=size[v];
            par[v]=u;
        }else{
            size[v]+=size[u];
            par[u]=v;
        }
    }
    
    int find(int u){
        while(u!=par[u]){
            u=par[u];
        }
        return u;
    }
    
    int validSubarraySize(vector<int>& nums, int threshold) {
        int n=nums.size();
        vector<pair<int,int>>numsp;
        for(int i=0;i<n;i++){
            size[i]=1;
            par[i]=i;
            numsp.push_back({nums[i],i});
            
        }
        sort(numsp.begin(),numsp.end());
        reverse(numsp.begin(),numsp.end());
        set<int>st;
        for(int i=0;i<numsp.size();i++){
            
            int ind=numsp[i].second;
            int val=numsp[i].first;
        //    cout<<val<<' '<<ind<<"\n";
            if(st.find(ind+1)!=st.end()){
                int parind=find(ind);
                int parindp=find(ind+1);
                unionT(parind,parindp);
            }
            if(st.find(ind-1)!=st.end()){
                int parind=find(ind);
                int parindp=find(ind-1);
                unionT(parind,parindp);
            }
            
            int parind=find(ind);
            if(val>threshold/size[parind]){
                return size[parind];
            }
            st.insert(ind);
        }
        return -1;
    }
};