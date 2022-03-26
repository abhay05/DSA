class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int n=costs.size();
        pair<int,int>arr[n];//= new pair<int,int>[n];
        for(int i=0;i<n;i++){
            arr[i]={costs[i][1]-costs[i][0],i};
        }
        sort(arr,arr+n);
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=costs[arr[i].second][1];
        }
        for(int i=n/2;i<n;i++){
            ans+=costs[arr[i].second][0];
        }
        return ans;
    }
};